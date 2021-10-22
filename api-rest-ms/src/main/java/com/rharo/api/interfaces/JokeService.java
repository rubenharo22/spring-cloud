package com.rharo.api.interfaces;

import java.util.List;

import com.rharo.generated.model.JokeDto;

/**
 * The Interface JokeService.
 */
public interface JokeService {


	/**
	 * Find by category.
	 *
	 * @param id the id
	 * @return the joke dto
	 */
	JokeDto findByCategory(String categoryJokeId);

	/**
	 * Find joke.
	 *
	 * @return the joke dto
	 */
	JokeDto findJoke();
	
	/**
	 * Find categories joke.
	 *
	 * @return the list
	 */
	List<String> findCategoriesJoke();
}
