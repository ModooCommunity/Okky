package com.okky.okkyclone.Board.dto;

import com.okky.okkyclone.review.entity.Review;
import lombok.Getter;

import java.util.List;

@Getter
public class BoardDetailRepDto {

    private String nickname;

    private String title;

    private int viewCount;

    private List<Review> comments;
}
