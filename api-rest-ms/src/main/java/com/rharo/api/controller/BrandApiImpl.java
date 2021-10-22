package com.rharo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.rharo.api.constant.Constants;
import com.rharo.api.interfaces.BrandService;
import com.rharo.generated.api.BrandApi;
import com.rharo.generated.model.BrandDto;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "brand" })
@Controller
@Slf4j
public class BrandApiImpl implements BrandApi {

	@Autowired
	private BrandService brandService;

	@Override
	public ResponseEntity<List<BrandDto>> getBrand() {

		log.info(Constants.LOG_CALL_SERVICE, "getBrand");

		return ResponseEntity.ok(brandService.findAll());
	}

	@Override
	public ResponseEntity<BrandDto> getBrandDetail(Long brandId) {

		log.info(Constants.LOG_CALL_SERVICE, "getBrandDetail");

		return ResponseEntity.ok(brandService.findById(brandId));
	}

}