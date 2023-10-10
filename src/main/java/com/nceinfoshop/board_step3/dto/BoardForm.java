package com.nceinfoshop.board_step3.dto;

public class BoardForm {
	private String title;
	private String content;
	
	public BoardForm(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "BoardForm [title=" + title + ", content=" + content + "]";
	}
}
