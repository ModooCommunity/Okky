package com.okky.okkyclone.review.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewResponseDto {

    private String content;

    @Builder
    public ReviewResponseDto(String content){
        this.content = content;
    }
}

