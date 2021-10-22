package com.rharo.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rharo.api.interfaces.ManufacturerService;
import com.rharo.generated.api.ManufacturerApi;
import com.rharo.generated.model.ManufacturerDto;

/**
 * The Class ManufacturerApiImplITTest, integration test, starts the context of spring
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = ManufacturerApiImpl.class)
public class ManufacturerApiImplITTest {

	private MockMvc mockMvc;

	@MockBean
	private ManufacturerService manufacturerService;

	@Autowired
	private ManufacturerApi manufacturerApi;

	private List<ManufacturerDto> listManufacturerDto = new ArrayList<>();

	@Before
	public void setUp() {
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(manufacturerApi).build();

		ManufacturerDto manufacturerDto1 = new ManufacturerDto();
		manufacturerDto1.setId(1L);
		manufacturerDto1.setMaxCarId(104L);
		manufacturerDto1.setName("chrysler");
		manufacturerDto1.setNumModels(3);
		manufacturerDto1.setAvgHorsepower(new BigDecimal(291.3333333333333));
		manufacturerDto1.setAvgPrice(new BigDecimal(32971.666666666664));
		manufacturerDto1.setImgUrl("http://www.carlogos.org/uploads/car-logos/Chrysler-logo-1.jpg");

		listManufacturerDto.add(manufacturerDto1);

		ManufacturerDto manufacturerDto2 = new ManufacturerDto();
		manufacturerDto2.setId(5L);
		manufacturerDto2.setMaxCarId(125L);
		manufacturerDto2.setName("ford");
		manufacturerDto2.setNumModels(19);
		manufacturerDto2.setAvgHorsepower(new BigDecimal(281.2631578947368));
		manufacturerDto2.setAvgPrice(new BigDecimal(34998.68421052631));
		manufacturerDto2.setImgUrl("http://www.carlogos.org/uploads/car-logos/Ford-logo-1.jpg");

		listManufacturerDto.add(manufacturerDto2);
		
		Mockito.when(manufacturerService.findAll()).thenReturn(listManufacturerDto);

	}

	@Test
	public void testGetManufacturerOK()  throws Exception {
		
		String url = "/manufacturer";
		MvcResult result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
		        .andReturn();

		List<ManufacturerDto> response = new ObjectMapper().
				readValue(result.getResponse().getContentAsString(), new TypeReference<List<ManufacturerDto>>() {});
		

		Assert.assertNotNull(response);
		Assert.assertEquals(2, response.size());
		Assert.assertEquals("chrysler", response.get(0).getName());
		Assert.assertEquals("ford", response.get(1).getName());
		Assert.assertEquals(104, response.get(0).getMaxCarId().longValue());
		Assert.assertEquals(125, response.get(1).getMaxCarId().longValue());
		

	}

}
