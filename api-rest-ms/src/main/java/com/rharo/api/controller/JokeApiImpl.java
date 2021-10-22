package com.rharo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.rharo.api.constant.Constants;
import com.rharo.api.interfaces.JokeService;
import com.rharo.generated.api.ChuckNorrisApi;
import com.rharo.generated.model.JokeDto;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "chuckNorris" })
@Controller
@Slf4j
public class JokeApiImpl implements ChuckNorrisApi {

	@Autowired
	private JokeService jokeService;

	@Override
	public ResponseEntity<JokeDto> getRandomJoke() {

		log.info(Constants.LOG_CALL_SERVICE, "getRandomJoke");

		return ResponseEntity.ok(jokeService.findJoke());
	}

	@Override
	public ResponseEntity<JokeDto> getRandomJokeByCategory(String categoryJokeId) {

		log.info(Constants.LOG_CALL_SERVICE, "getRandomJokeByCategory");

		return ResponseEntity.ok(jokeService.findByCategory(categoryJokeId));
	}

	@Override
	public ResponseEntity<List<String>> getCategoriesJoke() {

		log.info(Constants.LOG_CALL_SERVICE, "getCategoriesJoke");

		return ResponseEntity.ok(jokeService.findCategoriesJoke());
	}
}