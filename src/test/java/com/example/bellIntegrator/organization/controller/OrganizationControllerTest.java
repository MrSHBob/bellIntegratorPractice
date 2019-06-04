package com.example.bellIntegrator.organization.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
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

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
@AutoConfigureMockMvc
public class OrganizationControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Transactional
    public void allTests () throws Exception {
        this.organizationSaveGetTest();
        this.organizationUpdateTest();
        this.orgFilterTest();
    }

    @Test
    public void organizationSaveGetTest () throws Exception {
        OrganizationViewSave request = new OrganizationViewSave();
        request.isActive = true;
        request.address = "ул.Цюрупы, 16";
        request.fullName = "организация ООО \"Некая организация 1\"";
        request.name = "Некая организация 1";
        request.inn = "1234567890";
        request.kpp = "1234AZ01";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        //get test
        this.mockMvc.perform(get("/api/organization/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1));
        //wrong get test
        this.mockMvc.perform(get("/api/organization/55"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("answer is empty"));

        //wrong save tests
        request.kpp = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("kpp must be filled"));

        request.kpp = "1234AZ01";
        request.address = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("address must be filled"));

        request.address = "ул.Цюрупы, 16";
        request.fullName = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("fullName must be filled"));

        request.name = null;
        request.fullName = "организация ООО \"Некая организация 1\"";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name must be filled"));

        request.name = "Некая организация 1";
        request.inn = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("inn must be filled"));

        request.name = "Некая организация 1Некая организация 1Некая организа";
        request.inn = "1234567890";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name max size 50"));

        request.name = "Некая организация 1";
        request.fullName = "Некая организация 1Некая организация 1Некая организация 1Некая организация 1Некая организация 1" +
                "Некая организация 1Некая организация 1Некая организация 1Некая организация 1Некая организация 1" +
                "Некая организация 1";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("FullName max size 200"));

        request.fullName = "Некая организация 1";
        request.inn = "131213132121321332112";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("inn max size 20"));

        request.inn = "1234567890";
        request.kpp = "1234AZ01123123";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("kpp max size 9"));

        request.kpp = "1234AZ01";
        request.address = "ул.ЦюрупыЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюрупЦюруп, 16";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("address max size 100"));

        request.address = "ул.Цюрупы, 16";
        request.phone = "123132132132132123";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("phone max size 15"));
    }

    @Test
    public void organizationUpdateTest () throws Exception {
        OrganizationViewSave requestSava = new OrganizationViewSave();
        requestSava.isActive = true;
        requestSava.address = "ул.Цюрупы, 16";
        requestSava.fullName = "организация ООО \"Некая организация 1\"";
        requestSava.name = "Некая организация 1";
        requestSava.inn = "1234567890";
        requestSava.kpp = "1234AZ01";
        String requestJson = mapper.writeValueAsString(requestSava);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        OrganizationViewUpdate request = new OrganizationViewUpdate();
        request.id = 1L;
        request.name = "Некая организация 2";
        request.fullName = "организация ООО \"Некая организация 2\"";
        request.inn = "1234567890";
        request.kpp = "1234AZ01";
        request.address = "ул.Цюрупы, 16";
        request.phone = "555555";
        request.isActive = true;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        this.mockMvc.perform(get("/api/organization/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value("Некая организация 2"))
                .andExpect(jsonPath("$.data.inn").value("1234567890"));

        //wrong requests
        //wrong id
        request.id = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("id is required field"));
        request.id = 1L;

        //wrong name
        request.name = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name is required field"));

        request.name = "uqbriqgbiruqgiqvbiqubgqvbbugviweifwqbqivbqgfrbiqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name max size 50"));
        request.name = "Некая организация 2";

        //wrong fullName
        request.fullName = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("fullName is required field"));

        request.fullName = "uqbriqgbiruqgiqvbiqubgqvbbugviweifwqbqivbqgfrbiqqqquqbriqgbiruqgiqvbiqubgqvbbugviweifwqbqivbqgfrbiqqqq" +
                "uqbriqgbiruqgiqvbiqubgqvbbugviweifwqbqivbqgfrbiqqqquqbriqgbiruqgiqvbiqubgqvbbugviweifwqbqivbqgfrbiqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("FullName max size 200"));
        request.fullName = "организация ООО \"Некая организация 2\"";

        //wrong inn
        request.inn = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("inn is required field"));

        request.inn = "uqbriqgbiruqgiqvbiquq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("inn max size 20"));
        request.inn = "1234567890";

        //wrong kpp
        request.kpp = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("kpp is required field"));

        request.kpp = "qgiqvbiquq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("kpp max size 9"));
        request.kpp = "1234AZ01";

        //wrong address
        request.address = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("address is required field"));

        request.address = "avnrhiavhnaofhnoavihroanirvheurhnfovaenirhvofahnavrhnaoivhrnoeairhvnfoaihfrnvaoiuhnvoenhvoaeihnoaiehn";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("address max size 100"));
        request.address = "ул.Цюрупы, 16";

        //wrong phone
        request.phone = "5555555555555555";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("phone max size 15"));
        request.phone = "555555";
    }

    @Test
    public void orgFilterTest () throws Exception {
        //save some organization
        OrganizationViewSave requestSave = new OrganizationViewSave();
        requestSave.isActive = true;
        requestSave.address = "ул.Цюрупы, 16";
        requestSave.fullName = "организация ООО \"Некая организация 1\"";
        requestSave.name = "Некая организация 1";
        requestSave.inn = "1234567890";
        requestSave.kpp = "1234AZ01";
        String requestJson = mapper.writeValueAsString(requestSave);
        this.mockMvc.perform(post("/api/organization/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value("success"));

        //correct filter fields
        OrganizationViewListIn request = new OrganizationViewListIn();
        request.name = "организация";
        request.inn = "1234567890";
        request.isActive = true;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].name").value("Некая организация 1"));

        request.name = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name is required field"));

        request.name = "организацияnapevipaenvrpaeirnvpaevnrapvenrinqqqqqqq";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("name max size 50"));
        request.name = "организация";

        request.inn = "1234567890123123123123123";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/organization/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("inn max size 20"));
    }
}