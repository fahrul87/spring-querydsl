package com.fahrul.springquerydsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springquerydsl.dto.AuthorStatistic;
import com.fahrul.springquerydsl.entity.Author;
import com.fahrul.springquerydsl.entity.Book;

@RestController
@RequestMapping("/rest")
public class AuthBookService {

	@Autowired
	private AuthBookService authBookService;

	@PostMapping("/authors/book")
	public List<Author> saveAuthorWithBooks(@RequestBody List<Author> authors) {
		return authBookService.saveAuthorWithBooks(authors);
	}

	@GetMapping("/authors")
	public List<Author> getAllAuthors() {
		return authBookService.getAllAuthors();
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return authBookService.getAllBooks();
	}

	@GetMapping("/author/{email}")
	public Optional<Author> findAuthorByEmail(@PathVariable String email) {
		return authBookService.findAuthorByEmail(email);
	}

	@GetMapping("/authorStatistic")
	public List<AuthorStatistic> getAuthorStatistic() {
		return authBookService.getAuthorStatistic();
	}

	@GetMapping("/authors/fetchJoin")
	public List<Author> getAuthorsWithFecthJoin() {
		return authBookService.getAuthorsWithFecthJoin();
	}
}
