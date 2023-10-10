package com.nceinfoshop.board_step1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nceinfoshop.board_step1.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
