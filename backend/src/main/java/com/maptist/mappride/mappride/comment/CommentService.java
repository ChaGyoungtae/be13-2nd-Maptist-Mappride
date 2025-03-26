package com.maptist.mappride.mappride.comment;

import com.maptist.mappride.mappride.comment.dto.CommentCreateDto;
import com.maptist.mappride.mappride.comment.dto.CommentCreateResponseDto;
import com.maptist.mappride.mappride.comment.dto.CommentRequestDto;
import com.maptist.mappride.mappride.comment.dto.CommentUpdateDto;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.member.MemberRepository;
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
    private final MemberRepository memberRepository;

    // 댓글 생성
    // @RequestBody로 본문을 하나의 객체로 HTTP 요청 데이터 처리
    public CommentCreateResponseDto createComment(@RequestBody CommentCreateDto commentCreateDto) {

        Member member = memberService.getMember();

        Place place = placeRepository.findOne(commentCreateDto.getPlaceId());

        if(place == null) {
            throw new RuntimeException("Place not found");
        }

        // dto로부터 객체 생성
        Comment comment = commentCreateDto.toComment(member,place);

        Long id = commentRepository.create(comment);

        Optional<Comment> newComment = commentRepository.findById(id);

        if(newComment.isEmpty()){
            throw new RuntimeException("댓글 생성 실패");
        }

        CommentCreateResponseDto responseDto = commentCreateDto.toResponseDto(member.getName(), newComment.get().getComment(), member.getId(), newComment.get().getRegDate());
        return responseDto;
    }



    // 장소별 댓글 조회
    @Transactional(readOnly = true)
    public List<CommentRequestDto> findByPlaceId(Long placeId) {
        List<CommentRequestDto> commentRequestDtos = commentRepository.findCommentRequestDtoByPlaceId(placeId);

        return commentRequestDtos;
    }



    // 댓글 수정
    @Transactional
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
