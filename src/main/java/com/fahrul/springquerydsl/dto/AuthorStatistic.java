package com.fahrul.springquerydsl.dto;

import org.springframework.data.repository.NoRepositoryBean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoRepositoryBean
public class AuthorStatistic {

	private String authorName;
	private Long bookCount;

}
