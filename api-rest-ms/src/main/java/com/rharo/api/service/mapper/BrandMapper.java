package com.rharo.api.service.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.rharo.api.model.Brand;
import com.rharo.generated.model.BrandDto;

@Component
public class BrandMapper extends ModelMapper {

	public BrandMapper() {
		super();
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	protected void init() {

		PropertyMap<Brand, BrandDto> carMapping = new PropertyMap<Brand, BrandDto>() {
			@Override
			protected void configure() {

				// map(source.getId(), destination.getId());

			}

		};
		addMappings(carMapping);
	}

	public BrandDto convertToDto(Brand brand) {
		return map(brand, BrandDto.class);
	}

	public List<BrandDto> convertToDto(List<Brand> brandList) {

		List<BrandDto> brandDtoList = new ArrayList<>();

		brandList.forEach(brand -> brandDtoList.add(convertToDto(brand)));

		return brandDtoList;
	}

}