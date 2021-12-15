package com.fahrul.springquerydsl.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.fahrul.springquerydsl.dto.AuthorStatistic;
import com.fahrul.springquerydsl.entity.Author;
import com.fahrul.springquerydsl.repository.AuthorRepository;
import com.querydsl.core.types.Projections;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author, Integer> implements AuthorRepository {

	public AuthorRepositoryImpl(EntityManager em) {
		super(Author.class, em);

	}

	@Override
	public Optional<Author> findAuthorByEmail(String email) {

		return Optional
				.ofNullable(jpaQueryFactory.select(author).where(author.email.equalsIgnoreCase(email)).fetchFirst());
	}

	@Override
	public List<AuthorStatistic> getAuthorStatistic() {

		return jpaQueryFactory.from(author).innerJoin(author.books, book).groupBy(author.name)
				.select(Projections.constructor(AuthorStatistic.class, author.name, book.count())).fetch();
	}

	@Override
	public List<Author> getAuthors() {

		return jpaQueryFactory.select(author).distinct().from(author).innerJoin(author.books, book).fetchJoin().fetch();
	}

}
