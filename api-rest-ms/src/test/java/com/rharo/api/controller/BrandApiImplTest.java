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

import com.rharo.api.interfaces.BrandService;
import com.rharo.generated.model.BrandDto;

@RunWith(MockitoJUnitRunner.class)
public class BrandApiImplTest {

	@InjectMocks
	private BrandApiImpl brandApiImpl = new BrandApiImpl();

	@Mock
	private BrandService brandService;

	private List<BrandDto> listBrandDto = new ArrayList<>();

	@Before
	public void setUp() {

		BrandDto branDto1 = new BrandDto();
		branDto1.setId(1L);
		branDto1.setName("Mercedes");
		branDto1.setDescription("Marca Mercedes");
		listBrandDto.add(branDto1);

		BrandDto branDto2 = new BrandDto();
		branDto2.setId(2L);
		branDto2.setName("Audi");
		branDto2.setDescription("Marca Audi");
		listBrandDto.add(branDto2);

	}

	@Test
	public void testGetBrandOK() {

		Mockito.when(brandService.findAll()).thenReturn(listBrandDto);

		ResponseEntity<List<BrandDto>> response = brandApiImpl.getBrand();

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(2, response.getBody().size());
		Assert.assertEquals("Mercedes", response.getBody().get(0).getName());
		Assert.assertEquals("Audi", response.getBody().get(1).getName());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Test
	public void testGetBrandDetailOK() {

		final Long brandId = 1L;
		
		Mockito.when(brandService.findById(Mockito.anyLong())).thenReturn(listBrandDto.get(0));

		ResponseEntity<BrandDto>  response = brandApiImpl.getBrandDetail(brandId);

		Assert.assertNotNull(response);
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals("Mercedes", response.getBody().getName());
		Assert.assertEquals("Marca Mercedes", response.getBody().getDescription());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
}
