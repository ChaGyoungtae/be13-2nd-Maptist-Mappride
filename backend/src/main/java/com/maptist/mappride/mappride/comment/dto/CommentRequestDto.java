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
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    private String comment;

    private Long placeId;

    private Long memberId;

    private String memberName;

    private LocalDateTime regDate;



    public Comment toComment(Member member, Place place) {
        return Comment.builder()
                .member(member)
                .place(place)
                .comment(comment)
                .regDate(LocalDateTime.now())
                .build();
    }
}
