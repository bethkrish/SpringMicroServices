package com.vijayforvictory.movieinfo.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijayforvictory.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfo {

	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Gladiator");
	}

}
