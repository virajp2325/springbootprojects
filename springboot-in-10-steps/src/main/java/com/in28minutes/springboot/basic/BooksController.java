package com.in28minutes.springboot.basic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	@GetMapping("/books")

	public List<Books> getAllBooks() {

		return Arrays.asList(new Books(1l, "Mastering Spring 5.1", "Ranga Mankaram"));
	}

}
