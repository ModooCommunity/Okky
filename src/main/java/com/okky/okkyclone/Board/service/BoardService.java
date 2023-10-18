package com.okky.okkyclone.Board.service;

import com.okky.okkyclone.Board.entity.Board;

public interface BoardService {

    void registerBoard(Board board);

    Board editBoard(Board board, Long questionId);

    void deleteBoard(Long questionId);

    Board findVerifiedBoard(Long questionId);
}
