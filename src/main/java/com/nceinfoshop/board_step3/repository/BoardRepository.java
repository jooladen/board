package com.nceinfoshop.board_step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nceinfoshop.board_step3.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
