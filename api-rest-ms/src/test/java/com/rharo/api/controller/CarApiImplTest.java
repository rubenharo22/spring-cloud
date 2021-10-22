package com.rharo.api.controller;

import java.util.ArrayList;
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

import com.rharo.api.interfaces.CarService;
import com.rharo.generated.model.CarDto;

@RunWith(MockitoJUnitRunner.class)
public class CarApiImplTest {

	@InjectMocks
	private CarApiImpl carApiImpl = new CarApiImpl();

	@Mock
	private CarService carService;

	private List<CarDto> listCarDto = new ArrayList<>();

	@Before
	public void setUp() {

		CarDto carDto1 = new CarDto();
		carDto1.setId(1L);
		carDto1.setModel("c200");
		carDto1.setColor("rojo");
		carDto1.setBrandName("Mercedes");
		listCarDto.add(carDto1);

		CarDto carDto2 = new CarDto();
		carDto2.setId(2L);
		carDto2.setModel("a1");
		carDto2.setColor("negro");
		carDto2.setBrandName("Audi");
		listCarDto.add(carDto2);

	}

	@Test
	public void testGetCarOK() {

		Mockito.when(carService.findAll()).thenReturn(listCarDto);

		ResponseEntity<List<CarDto>> response = carApiImpl.getCar();

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(2, response.getBody().size());
		Assert.assertEquals("Mercedes", response.getBody().get(0).getBrandName());
		Assert.assertEquals("Audi", response.getBody().get(1).getBrandName());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testGetCarDetailOK() {

		final Long carId = 1L;

		Mockito.when(carService.findById(Mockito.anyLong())).thenReturn(listCarDto.get(1));

		ResponseEntity<CarDto> response = carApiImpl.getCarDetail(carId);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("Audi", response.getBody().getBrandName());
		Assert.assertEquals("negro", response.getBody().getColor());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}
}
