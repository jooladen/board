package com.nceinfoshop.board_step2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nceinfoshop.board_step2.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
