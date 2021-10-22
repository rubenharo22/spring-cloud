package com.rharo.api.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rharo.generated.model.JokeDto;

@FeignClient(name = "chuckNorris", url = "${openfeign.basePath.chuck-norris-api}")
public interface JokeFeignClient {

	@GetMapping(value = "/random")
	JokeDto getRandomChuck();

	@GetMapping(value = "/random")
	JokeDto getRandomChuckByCategory(@RequestParam(value = "category") String category);

	@GetMapping(value = "/categories")
	List<String> getCategories();
}
