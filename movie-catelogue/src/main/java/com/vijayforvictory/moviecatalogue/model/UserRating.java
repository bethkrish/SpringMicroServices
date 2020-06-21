package com.vijayforvictory.moviecatalogue.model;

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
