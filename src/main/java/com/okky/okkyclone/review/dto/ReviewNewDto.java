package com.okky.okkyclone.review.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class ReviewNewDto {

    @NotBlank(message = "댓글란을 작성해주세요.")
    private String review;

}
