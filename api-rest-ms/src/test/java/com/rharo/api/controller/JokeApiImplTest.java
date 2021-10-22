package com.rharo.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rharo.api.interfaces.JokeService;
import com.rharo.generated.model.JokeDto;

@RunWith(MockitoJUnitRunner.class)
public class JokeApiImplTest {

	@InjectMocks
	private JokeApiImpl jokeApiImpl = new JokeApiImpl();

	@Mock
	private JokeService jokeService;

	private List<JokeDto> listJokeDto = new ArrayList<>();

	@Before
	public void setUp() {

		JokeDto jokeDto1 = new JokeDto();
		jokeDto1.setId("3xGf-H2yTrOnExxvbK4vZA");
		jokeDto1.setValue("Chuck Norris can make the Goodyear blimp do a barrel-roll.");
		jokeDto1.setCreatedAt("2020-01-05 13:42:21.455187");
		jokeDto1.setUpdatedAt("2020-01-05 13:42:21.455187");
		jokeDto1.setIconUrl("https://assets.chucknorris.host/img/avatar/chuck-norris.png");

		listJokeDto.add(jokeDto1);

		JokeDto jokeDto2 = new JokeDto();
		jokeDto2.setId("_gczr0ctrjaia-asoqxbrq");
		jokeDto2.setValue(
				"If Chuck Norris were a calendar, every month would be named Chucktober, and every day he'd kick your ass.");
		jokeDto2.setCreatedAt("2020-01-05 13:42:19.104863");
		jokeDto2.setUpdatedAt("2020-01-05 13:42:19.104863");
		jokeDto2.setIconUrl("https://assets.chucknorris.host/img/avatar/chuck-norris.png");

		listJokeDto.add(jokeDto2);

	}

	@Test
	public void testGetRandomJokeOK() {

		Mockito.when(jokeService.findJoke()).thenReturn(listJokeDto.get(0));

		ResponseEntity<JokeDto> response = jokeApiImpl.getRandomJoke();

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("3xGf-H2yTrOnExxvbK4vZA", response.getBody().getId());
		Assert.assertEquals("Chuck Norris can make the Goodyear blimp do a barrel-roll.",
				response.getBody().getValue());
		Assert.assertEquals("2020-01-05 13:42:21.455187", response.getBody().getCreatedAt());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testGetRandomJokeByCategoryOK() {

		final String categoryJokeId = "game";

		Mockito.when(jokeService.findByCategory(Mockito.anyString())).thenReturn(listJokeDto.get(1));

		ResponseEntity<JokeDto> response = jokeApiImpl.getRandomJokeByCategory(categoryJokeId);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("_gczr0ctrjaia-asoqxbrq", response.getBody().getId());
		Assert.assertEquals(
				"If Chuck Norris were a calendar, every month would be named Chucktober, and every day he'd kick your ass.",
				response.getBody().getValue());
		Assert.assertEquals("2020-01-05 13:42:19.104863", response.getBody().getCreatedAt());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testGetCategoriesJokeOK() {

		List<String> categories = Arrays.asList("animal", "food", "money", "music");

		Mockito.when(jokeService.findCategoriesJoke()).thenReturn(categories);

		ResponseEntity<List<String>> response = jokeApiImpl.getCategoriesJoke();

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(4, response.getBody().size());
		Assert.assertEquals("animal", response.getBody().get(0));
		Assert.assertEquals("music", response.getBody().get(3));
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}
