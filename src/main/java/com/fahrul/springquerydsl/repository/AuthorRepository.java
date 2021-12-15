package com.fahrul.springquerydsl.repository;

import java.util.List;
import java.util.Optional;

import com.fahrul.springquerydsl.dto.AuthorStatistic;
import com.fahrul.springquerydsl.entity.Author;

public interface AuthorRepository extends BaseRepository<Author, Integer> {
	public Optional<Author> findAuthorByEmail(String email);

	public List<AuthorStatistic> getAuthorStatistic();

	public List<Author> getAuthors();
}
