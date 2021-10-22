package com.rharo.api.interfaces;

import java.util.List;

import com.rharo.generated.model.CarDto;

/**
 * The Interface CarService.
 */
public interface CarService {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the car dto
	 */
	CarDto findById(Long id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<CarDto> findAll();
}
