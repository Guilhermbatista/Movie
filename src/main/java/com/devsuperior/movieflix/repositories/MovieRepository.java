package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = """

			SELECT TB_MOVIE.ID,TB_MOVIE.TITLE, TB_MOVIE.SUB_TITLE, TB_MOVIE.MOVIE_YEAR, TB_MOVIE.IMG_URL FROM TB_MOVIE
			JOIN TB_GENRE
			WHERE TB_MOVIE.GENRE_ID = TB_GENRE.ID
			ORDER BY TB_MOVIE.TITLE
			""", countQuery = """
			SELECT TB_MOVIE.ID,TB_MOVIE.TITLE, TB_MOVIE.SUB_TITLE, TB_MOVIE.MOVIE_YEAR, TB_MOVIE.IMG_URL FROM TB_MOVIE
			JOIN TB_GENRE
			WHERE TB_MOVIE.GENRE_ID = TB_GENRE.ID
			ORDER BY TB_MOVIE.TITLE
			
					""")
	Page<MovieProjection> searchByMovieOrder(Pageable pageable);
}
