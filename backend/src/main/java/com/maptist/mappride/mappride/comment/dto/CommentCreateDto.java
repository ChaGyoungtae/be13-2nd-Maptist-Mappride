package com.maptist.mappride.mappride.comment.dto;

import com.maptist.mappride.mappride.comment.Comment;
import com.maptist.mappride.mappride.member.Member;
import com.maptist.mappride.mappride.place.Place;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDto {

    private String comment;

    private Long placeId;




    public Comment toComment(Member member, Place place) {
        return Comment.builder()
                .member(member)
                .place(place)
                .comment(comment)
                .regDate(LocalDateTime.now())
                .build();
    }

    public CommentCreateResponseDto toResponseDto(String memberName, String comment, Long memberId, LocalDateTime regDate){
        return CommentCreateResponseDto.builder()
                .memberName(memberName)
                .comment(comment)
                .regDate(regDate)
                .memberId(memberId)
                .build();
    }
}
