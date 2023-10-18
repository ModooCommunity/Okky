package com.okky.okkyclone.exception;

import lombok.Getter;

public enum ExceptionCode {
    // MEMBER
    MEMBER_NOT_FOUND(404, "Member not found"),

    // TOPIC
    TOPIC_NOT_FOUND(404,"Topic not found"),

    // BOARD
    BOARD_NOT_FOUND(404,"Board not found"),

    // REVIEW
    REVIEW_NOT_FOUND(404, "Review not found"),

    // AUTH
    USERNAME_NOT_FOUND(404, "Username not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
