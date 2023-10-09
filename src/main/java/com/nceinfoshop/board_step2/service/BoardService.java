package com.nceinfoshop.board_step2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nceinfoshop.board_step2.entity.Board;
import com.nceinfoshop.board_step2.repository.BoardRepository;



@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public void write(Board board) {
		boardRepository.save(board);
	}
}
