package com.vijayforvictory.moviecatalogue.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.vijayforvictory.moviecatalogue.model.CatalogueItem;
import com.vijayforvictory.moviecatalogue.model.Movie;
import com.vijayforvictory.moviecatalogue.model.Rating;
import com.vijayforvictory.moviecatalogue.model.UserRating;

@RestController
@RequestMapping("/catalogue")
public class MovieCatalogue {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogueItem> getCatalouge(@PathVariable("userId") String userId) {

		UserRating userRating = restTemplate.getForObject("http://localhost:9030/ratingdata/users/vijay", UserRating.class);

		return userRating.getUserRating().stream().map(rating -> {

			Movie movie = restTemplate.getForObject("http://localhost:9020/movies/" + rating.getMovieId(), Movie.class);

			// Movie movie =
			// webClientBuilder.build().get().uri("http://localhost:9020/movies/"
			// +
			// rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();

			return new CatalogueItem(movie.getName(), "Transforming Machines", rating.getRating());
		}).collect(Collectors.toList());

	}

	/**
	 * This is the duplicate implementation to iterate using for loop
	 * 
	 * @param ratings
	 * @return
	 */
	private List<CatalogueItem> getItems(List<Rating> ratings) {
		List<CatalogueItem> catalogueItems = new ArrayList<CatalogueItem>();

		for (Rating rating : ratings) {
			Movie movie = restTemplate.getForObject("http://localhost:9020/movies/" + rating.getMovieId(), Movie.class);
			catalogueItems.add(new CatalogueItem(movie.getName(), "Movie Description", rating.getRating()));
		}
		return catalogueItems;
	}
}
