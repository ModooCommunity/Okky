package com.okky.okkyclone.Board.repository;

import com.okky.okkyclone.Board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
