package com.rharo.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.rharo.generated.model.ManufacturerDto;

@FeignClient(name = "api", url = "${openfeign.basePath.cars-api}", configuration = { FeignConfig.class })
public interface CarFeignClient {

	@GetMapping(value = "/manufacturers")
	ResponseEntity<List<ManufacturerDto>> getAllManufacturers();
}
