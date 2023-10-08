package com.nceinfoshop.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nceinfoshop.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
