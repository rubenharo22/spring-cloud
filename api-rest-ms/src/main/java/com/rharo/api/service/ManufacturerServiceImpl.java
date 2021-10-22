package com.rharo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rharo.api.client.CarFeignClient;
import com.rharo.api.interfaces.ManufacturerService;
import com.rharo.generated.model.ManufacturerDto;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private CarFeignClient feignClient;

	@Override
	public List<ManufacturerDto> findAll() {

		ResponseEntity<List<ManufacturerDto>> response = feignClient.getAllManufacturers();

		return response.getBody();
	}
}