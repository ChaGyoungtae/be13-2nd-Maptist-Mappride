package com.maptist.mappride.mappride.comment;

import com.maptist.mappride.mappride.comment.dto.CommentRequestDto;
import com.maptist.mappride.mappride.comment.dto.CommentUpdateDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    // 댓글 생성
    public Long create(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }


    // 장소별 댓글 조회
    public List<CommentRequestDto> findCommentRequestDtoByPlaceId(Long placeId) {
        return em.createQuery(
                        "SELECT new com.maptist.mappride.mappride.comment.dto.CommentRequestDto(" +
                                "c.comment, c.place.id, c.member.id, c.member.name, c.regDate) " + // member.name과 regDate 추가
                                "FROM Comment c WHERE c.place.id = :placeId", CommentRequestDto.class)
                .setParameter("placeId", placeId)
                .getResultList();
    }

//    public List<CommentRequestDto> findCommentRequestDtoByPlaceId(Long placeId) {
//        return em.createQuery("SELECT new com.maptist.mappride.mappride.comment.dto.CommentRequestDto(c.comment, c.place.id, c.member.id) "
//                                + "FROM Comment c WHERE c.place.id = :placeId", CommentRequestDto.class)
//                .setParameter("placeId", placeId)
//                .getResultList();
//    }



    // 댓글 수정
    public void updateComment(CommentUpdateDto commentUpdateDto) {
        String query = """
                UPDATE Comment c
                SET c.comment = :comment
                WHERE c.id = :id
                """;

       em.createQuery(query)
               .setParameter("comment", commentUpdateDto.getComment())
               .setParameter("id", commentUpdateDto.getId())
               .executeUpdate();
    }

    // 댓글 삭제
    public void delete(Comment findComment) {
        em.remove(findComment);
    }

    public Optional<Comment> findById(Long commentId) {
        return Optional.ofNullable(em.find(Comment.class, commentId));
    }

    public List<Comment> findCommentsByMemberId(Long memberId){
        return em.createQuery("select c " +
                "from Comment c " +
                "where c.member.id =: memberId", Comment.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    public List<Comment> findByPlaceId(Long placeId){

        return em.createQuery("select c " +
                        "from Comment c " +
                        "where c.place.id =: placeId", Comment.class)
                .setParameter("placeId", placeId)
                .getResultList();
    }
}
