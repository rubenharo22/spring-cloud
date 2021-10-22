package com.rharo.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rharo.api.interfaces.CarService;
import com.rharo.api.model.Car;
import com.rharo.api.service.mapper.CarMapper;
import com.rharo.generated.model.CarDto;
import com.speedment.jpastreamer.application.JPAStreamer;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private JPAStreamer jpaStreamer;

	@Autowired
	private CarMapper carMapper;

	@Override
	public List<CarDto> findAll() {

		List<Car> carList = jpaStreamer.stream(Car.class).collect(Collectors.toList());

		return carMapper.convertToDto(carList);
	}

	@Override
	public CarDto findById(Long id) {

		Car car = jpaStreamer.stream(Car.class).filter(item -> item.getId().equals(id)).findFirst().orElseThrow();

		return carMapper.convertToDto(car);
	}

}