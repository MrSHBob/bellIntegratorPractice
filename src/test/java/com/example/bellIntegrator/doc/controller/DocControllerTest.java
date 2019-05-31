package com.example.bellIntegrator.doc.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.doc.view.DocViewSave;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
@AutoConfigureMockMvc
public class DocControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void docAddTest () throws Exception {
        DocViewSave request = new DocViewSave();
        request.code = 21;
        request.name = "Паспорт гражданина Российской Федерации";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        //wrong fields
        request.name = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name must not be empty"));

        request.code = null;
        request.name = "Паспорт гражданина Российской Федерации";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("code must not be empty"));

        request.code = 21;
        request.name = "Паспорт гражданина Российской ФедерацииПаспорт гражданина Российской ФедерацииПаспорт гражданина " +
                "Российской ФедерацииПаспорт гражданина Российской ФедерацииПаспорт гражданина Российской Федерации" +
                "Паспорт гражданина Российской ФедерацииПаспорт гражданина Российской ФедерацииПаспорт гражданина Российской Федерации";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name max size 200"));
    }

    @Test
    public void docGetAllTest () throws Exception {
        this.mockMvc.perform(get("/api/docs").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray());
    }
}