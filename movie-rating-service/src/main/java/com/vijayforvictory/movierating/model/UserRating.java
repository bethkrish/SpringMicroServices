package com.vijayforvictory.movierating.model;

import java.util.List;

public class UserRating {
	private List<Rating> userRating;

	/**
	 * 
	 */
	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userRating
	 */
	public UserRating(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	/**
	 * @return the userRating
	 */
	public List<Rating> getUserRating() {
		return userRating;
	}

	/**
	 * @param userRating
	 *            the userRating to set
	 */
	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

}
