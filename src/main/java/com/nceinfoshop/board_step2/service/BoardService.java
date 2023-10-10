package com.nceinfoshop.board_step2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nceinfoshop.board_step2.entity.Board;
import com.nceinfoshop.board_step2.repository.BoardRepository;



@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	//글 작성 처리
	public void write(Board board) {
		boardRepository.save(board);
	}
	
	//게시글 리스트 처리
	public List<Board> boardList(){
		return boardRepository.findAll();
	}
	
	//특정 게시글 불러오기
	public Board boardView(Board board) {
		return boardRepository.findById(board.getId()).get();
	}
	
	//특정 게시글 불러오기
	public Board boardView(Long id) {
		return boardRepository.findById(id).get();
	}
	
	//특정 게시글 삭제하기
	public void boardDelete(Long id) {
		boardRepository.deleteById(id);
	}
}
