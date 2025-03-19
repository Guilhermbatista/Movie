package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieProjection;

public class MovieCardDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;

    public MovieCardDTO(Movie dto) {
    	id = dto.getId();
    	title = dto.getTitle();
    	subTitle = dto.getSubTitle();
    	year = dto.getYear();
    	imgUrl = dto.getImgUrl();
	}
    public MovieCardDTO(MovieProjection projection) {
    	id = projection.getId();
    	title = projection.getTitle();
    	subTitle = projection.getSubTitle();
    	year = projection.getYear();
    	imgUrl = projection.getImgUrl();
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
