package com.rharo.api.interfaces;

import java.util.List;

import com.rharo.generated.model.BrandDto;

/**
 * The Interface BrandService.
 */
public interface BrandService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<BrandDto> findAll();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the brand
	 */
	BrandDto findById(Long id);

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	List<BrandDto> findByName(String name);
}
