package com.fahrul.springquerydsl.repository.impl;

import javax.persistence.EntityManager;

import com.fahrul.springquerydsl.entity.Book;
import com.fahrul.springquerydsl.repository.BookRepository;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

	public BookRepositoryImpl(EntityManager em) {
		super(Book.class, em);
	}

}
