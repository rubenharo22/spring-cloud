package com.rharo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rharo.api.client.JokeFeignClient;
import com.rharo.api.interfaces.JokeService;
import com.rharo.generated.model.JokeDto;

@Service
public class JokeServiceImpl implements JokeService {

	@Autowired
	private JokeFeignClient jokeFeignClient;

	@Override
	public JokeDto findJoke() {

		return jokeFeignClient.getRandomChuck();
	}

	@Override
	public JokeDto findByCategory(String categoryJokeId) {

		return jokeFeignClient.getRandomChuckByCategory(categoryJokeId);
	}

	@Override
	public List<String> findCategoriesJoke() {

		return jokeFeignClient.getCategories();
	}
}