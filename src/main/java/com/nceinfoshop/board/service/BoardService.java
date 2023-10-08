package com.nceinfoshop.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nceinfoshop.board.entity.Board;
import com.nceinfoshop.board.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public void write(Board board) {
		boardRepository.save(board);
	}
}
