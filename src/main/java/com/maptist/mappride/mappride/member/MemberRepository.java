package com.maptist.mappride.mappride.member;

import com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto;
import com.maptist.mappride.mappride.member.DTO.MemberDto;
import com.maptist.mappride.mappride.member.DTO.MemberEmailDto;
import com.maptist.mappride.mappride.member.DTO.MemberNameDto;
import com.maptist.mappride.mappride.member.DTO.MemberNicknameDto;
import com.maptist.mappride.mappride.member.DTO.MemberUpdateDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberDto(m)
            FROM Member m
            WHERE m.id = :memberId
            """;

        return em.createQuery(query, MemberDto.class)
                .setParameter("memberId", memberId)
                .getSingleResult();

    }

    // 내 정보 수정
    public void updateMyInfo(MemberUpdateDto memberDto)
    {
        String query = """
                UPDATE Member m
                SET m.nickname = :nickname, m.birthDay = :birthDay
                WHERE m.id = :id
                """;

        em.createQuery(query)
                .setParameter("nickname", memberDto.getNickName())
                .setParameter("birthDay", memberDto.getBirthDay())
                .setParameter("id", memberDto.getId())
                .executeUpdate();
    }

    // 내 카테고리 조회 (페이지 이동)
    public List<CategoryByMemberResponseDto> getCategories(Long memberId) {

        String query = """
                SELECT new com.maptist.mappride.mappride.categoryByMember.DTO.CategoryByMemberResponseDto(c, cbm.member.id)
                FROM Category c
                JOIN CategoryByMember cbm ON c.id = cbm.category.id
                WHERE cbm.member.id = :memberId
                """;

        return em.createQuery(query, CategoryByMemberResponseDto.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    //멤버 검색 (이름)
    public List<MemberNameDto> selectOtherName(String name)
    {
        String query = """
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberNameDto(m.name)
            FROM Member m
            WHERE m.name = :name
            """;

        return em.createQuery(query, MemberNameDto.class)
                .setParameter("name", name)
                .getResultList();
    }

    // 멤버 검색 (이메일)
    public MemberEmailDto selectOtherEmail(String email)
    {
        String query = """
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberEmailDto(m.email)
            FROM Member m
            WHERE m.email = :email
            """;

        return em.createQuery(query, MemberEmailDto.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    // 멤버 검색 (닉네임)
    public MemberNicknameDto selectOtherNickname(String nickName)
    {
        String query = """
            SELECT new com.maptist.mappride.mappride.member.DTO.MemberNicknameDto(m.nickname)
            FROM Member m
            WHERE m.nickname = :nickName
            """;

        return em.createQuery(query, MemberNicknameDto.class)
                .setParameter("nickName", nickName)
                .getSingleResult();
    }
}
