package com.fahrul.springquerydsl.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.fahrul.springquerydsl.entity.QAuthor;
import com.fahrul.springquerydsl.entity.QBook;
import com.fahrul.springquerydsl.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

	EntityManager em;
	JPAQueryFactory jpaQueryFactory;

	protected final QAuthor author = QAuthor.author;
	protected final QBook book = QBook.book;

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.em = em;
		this.jpaQueryFactory = new JPAQueryFactory(em);
	}

	@Override
	public T findByIdMandatory(ID id) throws IllegalArgumentException {

		return findById(id).orElseThrow(() -> new IllegalArgumentException("entity not found with id " + id));
	}

}
