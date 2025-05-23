package com.devsuperior.movieflix.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.repositories.GenreRepository;


@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	@Transactional(readOnly=true)
	public Page<GenreDTO>findAll(Pageable pageable) {
		return repository.findAll(pageable).map(x -> new GenreDTO(x));
	}
}
