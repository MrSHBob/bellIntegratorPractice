package com.example.bellIntegrator;

import com.example.bellIntegrator.country.controller.CountryController;
import com.example.bellIntegrator.country.controller.CountryControllerTest;
import com.example.bellIntegrator.country.view.CountryView;
import com.example.bellIntegrator.country.view.CountryViewSave;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest (classes = BellIntegratorApplication.class)
//@TestPropertySource("/test.properties")
@AutoConfigureMockMvc
public class BellIntegratorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CountryController countryController;

	@Test
	public void countryAddTest () throws Exception {
		CountryViewSave request = new CountryViewSave();
		request.code = 643;
		request.name = "Russia";

		String requestJson = objToJson(request);

		this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.result").value("success"));
	}

	private String objToJson (Object o) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String requestJson;
		requestJson = mapper.writeValueAsString(o);
		return requestJson;
	}
}
