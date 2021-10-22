package com.rharo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.rharo.api.constant.Constants;
import com.rharo.api.interfaces.ManufacturerService;
import com.rharo.generated.api.ManufacturerApi;
import com.rharo.generated.model.ManufacturerDto;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "manufacturer" })
@Controller
@Slf4j
public class ManufacturerApiImpl implements ManufacturerApi {

	@Autowired
	private ManufacturerService manufacturerService;

	@Override
	public ResponseEntity<List<ManufacturerDto>> getManufacturer() {

		log.info(Constants.LOG_CALL_SERVICE, "getManufacturer");

		return ResponseEntity.ok(manufacturerService.findAll());
	}
}