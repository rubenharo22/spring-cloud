package com.rharo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.rharo.api.constant.Constants;
import com.rharo.api.interfaces.CarService;
import com.rharo.generated.api.CarApi;
import com.rharo.generated.model.CarDto;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "car" })
@Controller
@Slf4j
public class CarApiImpl implements CarApi {

	@Autowired
	private CarService carService;

	@Override
	public ResponseEntity<List<CarDto>> getCar() {

		log.info(Constants.LOG_CALL_SERVICE, "getCar");

		return ResponseEntity.ok(carService.findAll());
	}

	@Override
	public ResponseEntity<CarDto> getCarDetail(Long carId) {

		log.info(Constants.LOG_CALL_SERVICE, "getCarDetail");

		return ResponseEntity.ok(carService.findById(carId));
	}
}