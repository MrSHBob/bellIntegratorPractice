package com.example.bellIntegrator.office.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.office.view.OfficeViewListIn;
import com.example.bellIntegrator.office.view.OfficeViewSave;
import com.example.bellIntegrator.office.view.OfficeViewUpdate;
import com.example.bellIntegrator.organization.view.OrganizationViewSave;
import com.example.bellIntegrator.response.view.DataView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedHashMap;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
@AutoConfigureMockMvc
public class OfficeControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void allTests () throws Exception {
        this.officeSaveGetTest();
        this.officeUpdateTest();
        this.officeFilterTest();
    }

    @Test
    @Transactional
    public void officeSaveGetTest () throws Exception {
        saveOrg();
        //save office
        OfficeViewSave request = new OfficeViewSave();
        request.orgId = 1L;
        request.name = "Some office";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.result").value("success"));
        //get id from office just saved
        OfficeViewListIn ovli = new OfficeViewListIn();
        ovli.orgId = 1L;
        ovli.name = request.name;
        String ovliJson = mapper.writeValueAsString(ovli);
        MvcResult mvcResult = this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(ovliJson))
                .andReturn();
        String resultString = mvcResult.getResponse().getContentAsString();
        DataView dataView = mapper.readValue(resultString, DataView.class);
        List<Object> listOuts = (List<Object>) dataView.data;
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>)listOuts.get(0);
        //get office by id
        this.mockMvc.perform(get("/api/office/" + linkedHashMap.get("id")))
                .andExpect(jsonPath("$.data.name").value(request.name));

        //wrong save param
        request.orgId = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("OrganizationId is required field"));
        request.orgId = 1L;

        request.name = "ehrowhegoiwehroweihgoewiruhwoeiruhgeorhgqqqqqqqqqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("name max size 50"));
        request.name = null;

        request.address = "owhegoiwehroweihgoewiruhwoeiruhgeorhgqqqqqqqqqqqqehrowhegoiwehroweihgoewiruhwoeiruhgeorhgqqqqqqqqqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("address max size 100"));
        request.address = null;

        request.phone = "1231231231231231";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("phone max size 15"));
        request.phone = null;

        //wrong get param
        this.mockMvc.perform(get("/api/office/1000"))
                .andExpect(jsonPath("$.error").value("answer is empty"));
    }

    @Test
    @Transactional
    public void officeUpdateTest () throws Exception {
        saveOff();
        OfficeViewUpdate request = new OfficeViewUpdate();
        request.id = 1L;
        request.name = "офис 1";
        request.address = "ул.Лунина, 7";
        request.phone = "666666";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.result").value("success"))
                .andDo(mvcResult -> {
                    this.mockMvc.perform(get("/api/office/1"))
                            .andExpect(jsonPath("$.data.name").value(request.name));
                });

        //wrong update requests
        request.id = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("Id is required field"));
        request.id = 1L;

        request.name = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("name is required field"));
        request.name = "pinvaenivnraevipnarpveiranvperinvaernpvqqqqqqqqqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("name max size 50"));
        request.name = "some office";

        request.address = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("address is required field"));
        request.address = "pinvaenivnraevipnarpveiranvperinvaernpvqqqqqqqqqqqqpinvaenivnraevipnarpveiranvperinvaernpvqqqqqqqqqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("address max size 100"));
        request.address = "ул.Лунина, 7";

        request.phone = "55555555555555555";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("phone max size 15"));
    }

    @Test
    @Transactional
    public void officeFilterTest () throws Exception {
        saveOff();
        OfficeViewListIn request = new OfficeViewListIn();
        request.orgId = 1L;
        request.name = "Some";
        request.phone = "666666";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.data[0].name").value("Some office"));

        //wrong filter requests
        request.orgId = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("OrganizationId is required field"));
        request.orgId = 1L;

        request.name = "lqwjbdjlqwbdlqbwlldqbwldqlwbjdbqlwjdblqwbdjqlwdqbwldbqjwbdlqjwdblqjwbdl";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("name max size 50"));
        request.name = "Some office";

        request.phone = "66666666666666666";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("phone max size 15"));
        request.phone = "666666";
    }

    private void saveOrg () throws Exception {
        OrganizationViewSave request = new OrganizationViewSave();
        request.isActive = true;
        request.address = "ул.Цюрупы, 16";
        request.fullName = "организация ООО \"Некая организация 1\"";
        request.name = "Некая организация 1";
        request.inn = "1234567890";
        request.kpp = "1234AZ01";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson));
    }

    private void saveOff () throws Exception {
        saveOrg();
        OfficeViewSave request = new OfficeViewSave();
        request.orgId = 1L;
        request.name = "Some office";
        request.phone = "666666";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/office/save").contentType(MediaType.APPLICATION_JSON).content(requestJson));
    }
}