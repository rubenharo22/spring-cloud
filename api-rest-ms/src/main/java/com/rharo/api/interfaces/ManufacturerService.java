package com.rharo.api.interfaces;

import java.util.List;

import com.rharo.generated.model.ManufacturerDto;

/**
 * The Interface ManufacturerService.
 */
public interface ManufacturerService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<ManufacturerDto> findAll();
}
