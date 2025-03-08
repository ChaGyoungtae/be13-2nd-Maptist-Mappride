package com.maptist.mappride.mappride.comment;

import com.maptist.mappride.mappride.comment.dto.CommentRequestDto;
import com.maptist.mappride.mappride.comment.dto.CommentUpdateDto;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberService;
import com.maptist.mappride.mappride.place.Place;
import com.maptist.mappride.mappride.place.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final PlaceRepository placeRepository;

    private final MemberService memberService;

    // 댓글 생성
    // @RequestBody로 본문을 하나의 객체로 HTTP 요청 데이터 처리
    public Long createComment(@RequestBody CommentRequestDto commentRequestDto) {

        Member member = memberService.getMember();

        Place place = placeRepository.findOne(commentRequestDto.getPlaceId());

        if(place == null) {
            throw new RuntimeException("Place not found");
        }

        // dto로부터 객체 생성
        Comment comment = commentRequestDto.toComment(member, place);

        Long id = commentRepository.create(comment);


        // 확인용 로그
        log.info("Comment created: {}", id);
        return id;
    }



//    // 장소별 댓글 조회
    @Transactional(readOnly = true)
    public List<CommentRequestDto> findByPlaceId(Long placeId) {
        List<CommentRequestDto> commentRequestDtos = commentRepository.findCommentRequestDtoByPlaceId(placeId);

        return commentRequestDtos;
    }

    // 댓글 수정
    public void updateComment(CommentUpdateDto dto) {
        commentRepository.updateComment(dto);
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        Optional<Comment> deleteComment = commentRepository.findById(commentId);
        if(deleteComment.isPresent()){
            Comment comment = deleteComment.get();
            if (comment.getMember() == memberService.getMember()) {
                commentRepository.delete(deleteComment.get());
            } else {
                throw new RuntimeException("본인의 댓글만 삭제할 수 있습니다.");
            }

        } else {
            log.info("Comment not found: {}", commentId);
        }

    }



}
