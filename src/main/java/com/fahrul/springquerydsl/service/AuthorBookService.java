package com.fahrul.springquerydsl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahrul.springquerydsl.dto.AuthorStatistic;
import com.fahrul.springquerydsl.entity.Author;
import com.fahrul.springquerydsl.entity.Book;
import com.fahrul.springquerydsl.repository.AuthorRepository;
import com.fahrul.springquerydsl.repository.BookRepository;

@Service
public class AuthorBookService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	public List<Author> saveAuthorsWithBooks(List<Author> authors) {
		return authorRepository.saveAll(authors);
	}

	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Optional<Author> findAuthorByEmail(String email) {
		return authorRepository.findAuthorByEmail(email);
	}

	public List<AuthorStatistic> getAuthorStatistic() {
		return authorRepository.getAuthorStatistic();
	}

	public List<Author> getAuthorsWithFetchJoin() {
		return authorRepository.getAuthors();
	}

}
