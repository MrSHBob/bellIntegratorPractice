package com.example.bellIntegrator.country.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.country.view.CountryView;
import com.example.bellIntegrator.country.view.CountryViewSave;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
@AutoConfigureMockMvc
public class CountryControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void allTests () throws Exception {
        this.countryAddTest();
        this.countryGetAllTest();
    }

    @Test
    public void countryAddTest () throws Exception {
        CountryViewSave request = new CountryViewSave();
        request.code = 643;
        request.name = "Russia";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        //wrong fields
        request.code = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("code must not be empty"));

        request.code = 643;
        request.name = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name must not be empty"));

        request.name = "RussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussia" +
                "RussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussia" +
                "RussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussiaRussia";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name max size is 200"));
    }

    @Test
    public void countryGetAllTest () throws Exception {
        this.mockMvc.perform(get("/api/countries").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}