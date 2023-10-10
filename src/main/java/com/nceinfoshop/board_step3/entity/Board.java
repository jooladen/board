package com.nceinfoshop.board_step3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue  //H2에서는 되던데 mysql에서 안먹음
	private Long id;
	private String title;
	private String content;
}
