package com.maptist.mappride.mappride.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class CommentCreateResponseDto {

    private final String memberName;
    private final String comment;
    private final LocalDateTime regDate;
    private final Long memberId;
}
