package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieAllProjection;
import com.devsuperior.movieflix.projections.MovieProjection;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	@Query(nativeQuery = true, value = """

			SELECT DISTINCT TB_MOVIE.ID,TB_MOVIE.TITLE, TB_MOVIE.SUB_TITLE, TB_MOVIE.MOVIE_YEAR, TB_MOVIE.IMG_URL 
			FROM TB_MOVIE
			JOIN TB_GENRE
			WHERE TB_MOVIE.GENRE_ID = :id
			ORDER BY TB_MOVIE.TITLE
			""", countQuery = """
			SELECT DISTINCT TB_MOVIE.ID,TB_MOVIE.TITLE, TB_MOVIE.SUB_TITLE, TB_MOVIE.MOVIE_YEAR, TB_MOVIE.IMG_URL 
			FROM TB_MOVIE
			JOIN TB_GENRE
			WHERE TB_MOVIE.GENRE_ID = :id
			ORDER BY TB_MOVIE.TITLE
			
					""")
	Page<MovieProjection> searchByMovieOrder(Long id, Pageable pageable);
	
	@Query(nativeQuery = true, value = """

			SELECT DISTINCT TB_MOVIE.genre_id, TB_MOVIE.title, TB_MOVIE.sub_title, TB_MOVIE.movie_year, TB_MOVIE.img_url
			FROM TB_MOVIE 
			ORDER BY TB_MOVIE.title;
			""", countQuery = """
			SELECT DISTINCT TB_MOVIE.genre_id, TB_MOVIE.title, TB_MOVIE.sub_title, TB_MOVIE.movie_year, TB_MOVIE.img_url
			FROM TB_MOVIE 
			ORDER BY TB_MOVIE.title;
			
					""")
	Page<MovieAllProjection> searchAllMoviesrder(Pageable pageable);
	
}
