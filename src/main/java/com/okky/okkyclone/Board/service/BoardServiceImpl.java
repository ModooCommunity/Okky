package com.okky.okkyclone.Board.service;

import com.okky.okkyclone.Board.entity.Board;
import com.okky.okkyclone.Board.repository.BoardRepository;
import com.okky.okkyclone.exception.BusinessLogicException;
import com.okky.okkyclone.exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public void registerBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public Board editBoard(Board board, Long questionId) {
        Board findBoard = this.findVerifiedBoard(questionId);
        Optional.ofNullable(board.getTopic())
                .ifPresent(topic -> findBoard.editTopic(topic));
        Optional.ofNullable(board.getTitle())
                .ifPresent(title -> findBoard.editTitle(title));
        Optional.ofNullable(board.getContent())
                .ifPresent(content -> findBoard.editContent(content));
        return boardRepository.save(findBoard);
    }

    @Override
    public void deleteBoard(Long questionId) {
        Board findBoard = this.findVerifiedBoard(questionId);
        boardRepository.delete(findBoard);
    }

    public Board findVerifiedBoard(Long questionId){
        return boardRepository.findById(questionId).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
