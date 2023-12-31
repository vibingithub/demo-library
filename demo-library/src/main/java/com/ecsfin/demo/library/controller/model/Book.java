package com.ecsfin.demo.library.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String bookId;
	private String name;
	private String genre;
	private String language;
}
