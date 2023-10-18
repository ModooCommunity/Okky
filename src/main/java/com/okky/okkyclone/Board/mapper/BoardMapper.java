package com.okky.okkyclone.Board.mapper;

import com.okky.okkyclone.Board.dto.BoardNewDto;
import com.okky.okkyclone.Board.dto.BoardResponseDto;
import com.okky.okkyclone.Board.entity.Board;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {

    public Board boardNewDtoToBoard(BoardNewDto boardNewDto){
        return new Board(
                boardNewDto.getTopic(),
                boardNewDto.getTitle(),
                boardNewDto.getContent()
        );
    }

    public BoardResponseDto boardToBoardResponseDto(Board board){
        return new BoardResponseDto(
                board.getTopic().getStepDescription(),
                board.getTitle(),
                board.getContent()
        );
    }


}
