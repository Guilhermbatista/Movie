package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

	@Autowired
	private GenreService service;

	@GetMapping()
	@PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	public ResponseEntity<Page<GenreDTO>> findAllPaged(Pageable pageable) {
		Page<GenreDTO> list = service.findAll(pageable);
		return ResponseEntity.ok().body(list);
	}

}
