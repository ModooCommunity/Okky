package com.okky.okkyclone.Board.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class BoardNewDto {

    @NotBlank(message = "주제를 지정해주세요.")
    private String topic;

    @NotBlank(message = "제목명을 작성해주세요.")
    private String title;

    @NotBlank(message = "내용을 작성해주세요.")
    private String content;
}
