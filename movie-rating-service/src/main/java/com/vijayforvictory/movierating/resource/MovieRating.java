package com.vijayforvictory.movierating.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijayforvictory.movierating.model.Rating;
import com.vijayforvictory.movierating.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class MovieRating {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}

	@RequestMapping("users/{userId}")
	public UserRating getRatings(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("100", 10), new Rating("200", 9), new Rating("300", 9));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
