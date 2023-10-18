package com.okky.okkyclone.Board.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private String topic;
    private String title;
    private String content;

    @Builder
    public BoardResponseDto(String topic, String title, String content){
        this.topic = topic;
        this.title = title;
        this.content = content;
    }
}
