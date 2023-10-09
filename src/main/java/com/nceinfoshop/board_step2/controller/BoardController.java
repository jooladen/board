package com.nceinfoshop.board_step2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nceinfoshop.board_step2.dto.BoardForm;
import com.nceinfoshop.board_step2.dto.BoardFormLombok;
import com.nceinfoshop.board_step2.entity.Board;
import com.nceinfoshop.board_step2.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/juststring")
	@ResponseBody //글자를 그대로 화면에 나오게 하는 어노테이션
	public String juststring() {
		return "Hello, world";
	}
	
	@GetMapping("/")
	public String main() {
		return "login";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.boardList());
		
		return "boardlist";
	}
	
	@GetMapping("/board/write")
	public String boardWriteForm() {
		
		return "boardwrite";
	}
	
	@GetMapping("/board/view")
	public String boardView(Model model, 
			@RequestParam(defaultValue="100") Long id) {
		model.addAttribute("boardDetail", boardService.boardView(id));
		return "boardview";
	}
	
	//일반변수 값 넘기기
	@PostMapping("/board/writedo")
	public String boardWriteDo(String title, String content) {
		System.out.println("title >>> " + title);
		System.out.println("content >>> " + content);
		
		return "";
	}
	
	@GetMapping("/board/write2")
	public String boardWriteForm2() {
		
		return "boardwrite2";
	}
	//DTO사용
	@PostMapping("/board/writedo2")
	public String boardWriteDo2(BoardForm form) {
		System.out.println(form);
		
		return "";
	}
	
	@GetMapping("/board/write3")
	public String boardWriteForm3() {
		
		return "boardwrite3";
	}
	//lombok사용
	@PostMapping("/board/writedo3")
	public String boardWriteDo3(BoardFormLombok form) {
		log.info(form.toString());
		log.info("form >>> ", form);
		log.info("form >>> {}", form);
		
		return "";
	} 
	
	@GetMapping("/board/write4")
	public String boardWriteForm4() {
		
		return "boardwrite4";
	}
	//Entity넘기기 - 비추,  dto entity 분리를 추천한다.
	@PostMapping("/board/writedo4")
	public String boardWriteDo4(Board board) {
		System.out.println("board >>> " + board);
		System.out.println("board >>> " + board.getTitle());
		System.out.println("board >>> " + board.getContent());
		log.info("board >> {}", board);
		log.info("board >> {}", board.getTitle());
		//log.debug는 안나옴
		log.debug("board >> {}", board.getContent());
		log.info("board >> {}", board.getContent());
		return "";
	}
	
	@GetMapping("/board/write5")
	public String boardWriteForm5() {
		
		return "boardwrite5";
	}
	//DB(MySQL)에 입력
	@PostMapping("/board/writedo5")
	public String boardWriteDo5(Board board) {
		log.info("board >> {}", board);
		boardService.write(board);
		//return "boardwrite5";
		return "login";
	}
}
