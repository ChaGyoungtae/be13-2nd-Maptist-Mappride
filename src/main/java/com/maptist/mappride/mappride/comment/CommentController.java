package com.maptist.mappride.mappride.comment;

import com.maptist.mappride.mappride.comment.dto.CommentRequestDto;
import com.maptist.mappride.mappride.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {

    private final CommentService commentService;


    // 댓글 생성
    @PostMapping
    public ResponseEntity<Long> createComment(@RequestBody CommentRequestDto dto) {
        Long commentId = commentService.createComment(dto);
        return ResponseEntity.ok().body(commentId);
    }

    // 댓글 조회
    @GetMapping("/{place-id}")
    public ResponseEntity<List<CommentRequestDto>> findByPlaceId(@PathVariable("place-id") Long placeId) {
        List<CommentRequestDto> commentRequestDtos = commentService.findByPlaceId(placeId);

        return ResponseEntity.ok().body(commentRequestDtos);

    }

    // 댓글 수정
    @PutMapping("/update")
    public ResponseEntity<Long> updateComment(@RequestBody CommentUpdateDto dto) {

        commentService.updateComment(dto);
        return ResponseEntity.ok().build();
    }

    // 댓글 삭제
    @DeleteMapping("/{comment-id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("comment-id") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
