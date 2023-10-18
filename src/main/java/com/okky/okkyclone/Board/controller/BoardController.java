package com.okky.okkyclone.Board.controller;

import com.okky.okkyclone.Board.dto.BoardNewDto;
import com.okky.okkyclone.Board.dto.BoardResponseDto;
import com.okky.okkyclone.Board.entity.Board;
import com.okky.okkyclone.Board.mapper.BoardMapper;
import com.okky.okkyclone.Board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RequestMapping("/question")
@RestController
public class BoardController {

    private final BoardMapper boardMapper;
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardMapper boardMapper, BoardService boardService){
        this.boardMapper = boardMapper;
        this.boardService = boardService;
    }

    //회원 상세
//    @GetMapping("/{question-id}")
//    public ResponseEntity<>

    @PostMapping("/new")
    public ResponseEntity<Void> registerBoard(@RequestBody @Valid BoardNewDto boardNewDto){
        Board newBoard = boardMapper.boardNewDtoToBoard(boardNewDto);
        boardService.registerBoard(newBoard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{question-id}")
    public ResponseEntity<BoardResponseDto> editBoard(@RequestBody @Valid BoardNewDto boardNewDto,
                                                      @Positive @PathVariable("question-id") Long questionId){
        Board editBoard = boardMapper.boardNewDtoToBoard(boardNewDto);
        Board updateBoard = boardService.editBoard(editBoard, questionId);
        return new ResponseEntity<>(boardMapper.boardToBoardResponseDto(updateBoard),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{question-id}")
    public ResponseEntity<Void> deleteBoard(@Positive @PathVariable("question-id") Long questionId){
        boardService.deleteBoard(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
