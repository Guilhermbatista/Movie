package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		return new MovieDetailsDTO(
				repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found")));
	}

	@Transactional(readOnly = true)
	public Page<MovieCardDTO> reviews(Pageable pageable) {
		return repository.searchAllMoviesrder(pageable).map(x -> new MovieCardDTO(x));
}

	@Transactional(readOnly = true)
	public Page<MovieCardDTO> searchMovieOrder(Long id, Pageable pageable) {
		return repository.searchByMovieOrder(id, pageable).map(x -> new MovieCardDTO(x));
	}
}
