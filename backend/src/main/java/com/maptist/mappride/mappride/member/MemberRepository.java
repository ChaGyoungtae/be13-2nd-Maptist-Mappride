package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.category.Category;
import com.maptist.mappride.mappride.category.dto.CategoryResponseDto;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberEmailDto;
import com.maptist.mappride.mappride.member.DTO.MemberNameDto;
import com.maptist.mappride.mappride.member.DTO.MemberNicknameDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Member findById(Long memberId){
        return em.find(Member.class, memberId);
    }

    public Optional<Member> findByEmail(String email) {
        try {
            return Optional.ofNullable(
                em.createQuery("SELECT m FROM Member m WHERE m.email = :email", Member.class)
                  .setParameter("email", email)
                  .getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
    public Long save(Member member){

        em.persist(member);
        return member.getId();
    }


    // 내 정보 조회
    public MemberDto selectMyInfo(Long memberId)
    {
        String query = """
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberDto(
            m.id, m.grade.name, m.email, m.name, m.nickname, m.birthDay,
            m.userRole, m.publish, m.scrapCnt)
            FROM Member m
            WHERE m.id = :memberId
            """;

        return em.createQuery(query, MemberDto.class)
                .setParameter("memberId", memberId)
                .getSingleResult();

    }

    public void updateBirthday(Long memberId, LocalDate birthday) {
        String query = """
                   UPDATE Member m
                   SET m.birthDay = :birthday
                   WHERE m.id = :memberId
                """;
        em.createQuery(query)
                .setParameter("memberId", memberId)
                .setParameter("birthday", birthday)
                .executeUpdate();
    }
    public void updateNickname(Long memberId, String nickname) {
        String query = """
                UPDATE Member m
                SET m.nickname = :nickname
                WHERE m.id = :memberId
                """;
        em.createQuery(query)
                .setParameter("memberId",memberId)
                .setParameter("nickname",nickname)
                .executeUpdate();
    }

    // 닉네임 중복 체크
    public Member findByNickname(String nickname)
    {
        try
        {
            return em.createQuery("SELECT m FROM Member m WHERE m.nickname = :nickname", Member.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            return null;
        }
    }

    // 내 카테고리 조회 (페이지 이동)
    public List<CategoryResponseDto> getCategories(Long memberId) {

        String query = """
                SELECT new com.maptist.mappride.mappride.category.dto.CategoryResponseDto(c)
                FROM Category c
                WHERE c.member.id = :memberId
                """;

        return em.createQuery(query, CategoryResponseDto.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    // 카테고리Id로 memberId찾기
    public Long findMemberIdByCategoryId(Long categoryId){
        Category result = em.createQuery("select cbm " +
                        "from Category cbm " +
                        "where cbm.id =: categoryId", Category.class)
                .setParameter("categoryId", categoryId)
                .getSingleResult();

        return result.getId();
    }

    //멤버 검색 (이름)
    public List<MemberNameDto> selectOtherName(String name)
    {
        String query = """
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberNameDto(m.name)
            FROM Member m
            WHERE m.name = :name and m.publish = true
            """;

        return em.createQuery(query, MemberNameDto.class)
                .setParameter("name", name)
                .getResultList();
    }

    // 멤버 검색 (이메일)
    public MemberEmailDto selectOtherEmail(String email)
    {
        try
        {
            String query = """
                SELECT new com.maptist.mappride.mappride.member.DTO.MemberEmailDto(m.email)
                FROM Member m
                WHERE m.email = :email and m.publish = true
                """;

            return em.createQuery(query, MemberEmailDto.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            return null;
        }
    }

    // 멤버 검색 (닉네임)
    public MemberNicknameDto selectOtherNickname(String nickname)
    {
        try
        {
            String query = """
                SELECT new com.maptist.mappride.mappride.member.DTO.MemberNicknameDto(m.nickname)
                FROM Member m
                WHERE m.nickname = :nickname and m.publish = true
                """;

            return em.createQuery(query, MemberNicknameDto.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            return null;
        }
    }

    public void delete(Member member) {
        em.remove(member);
    }

    public List<Member> findAll(){
        return em.createQuery("select m " +
                "from Member m", Member.class)
                .getResultList();
    }

}
