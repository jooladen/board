package com.nceinfoshop.board_step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nceinfoshop.board_step3.dto.BoardForm;
import com.nceinfoshop.board_step3.dto.BoardFormLombok;
import com.nceinfoshop.board_step3.entity.Board;
import com.nceinfoshop.board_step3.service.BoardService;

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
	
	//localhost:8090/board/list?page=1&size=10
	@GetMapping("/board/list")
	public String boardList(Model model, 
			@PageableDefault(page=0, size = 10, sort = "id", direction = Sort.Direction.DESC) 
	    	Pageable pageable) {
		model.addAttribute("list", boardService.boardList(pageable));
		
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
	
	@GetMapping("/board/delete")
	public String boardDelete(Long id) {
		boardService.boardDelete(id);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable Long id,
			                  Model model) {
		model.addAttribute("board", boardService.boardView(id));
		return "boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable Long id,
			                  Board board) {
		
		Board temp = boardService.boardView(id);
		temp.setTitle(board.getTitle());
		temp.setContent(board.getContent());
		
		boardService.write(temp);
		
		return "redirect:/board/list";
	}
	
	//일반변수 값 넘기기
	@PostMapping("/board/writedo")
	public String boardWriteDo(String title, String content) {
		System.out.println("title >>> " + title);
		System.out.println("content >>> " + content);
		
		return "redirect:/";
	}
	
	@GetMapping("/board/write2")
	public String boardWriteForm2() {
		
		return "boardwrite2";
	}
	//DTO사용
	@PostMapping("/board/writedo2")
	public String boardWriteDo2(BoardForm form) {
		System.out.println(form);
		
		return "redirect:/";
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
		
		return "redirect:/";
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
		return "redirect:/";
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
		return "redirect:/";
	}
}

