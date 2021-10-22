	package com.rharo.api.service.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.rharo.api.model.Car;
import com.rharo.generated.model.CarDto;

@Component
public class CarMapper extends ModelMapper {

	public CarMapper() {
		super();
	}

	/**
	 * Inits, only necessary configure the properties that are different in Car entity and CarDTo
	 */
	@PostConstruct
	protected void init() {

		PropertyMap<Car, CarDto> carMapping = new PropertyMap<Car, CarDto>() {
			@Override
			protected void configure() {

				map(source.getBrand().getName(), destination.getBrandName());

			}

		};
		addMappings(carMapping);
	}

	public CarDto convertToDto(Car car) {
		return map(car, CarDto.class);
	}

	public List<CarDto> convertToDto(List<Car> carList) {

		List<CarDto> carDtoList = new ArrayList<>();

		carList.forEach(car -> carDtoList.add(convertToDto(car)));

		return carDtoList;
	}

}