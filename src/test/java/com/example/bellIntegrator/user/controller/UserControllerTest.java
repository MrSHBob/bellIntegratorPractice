package com.example.bellIntegrator.user.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.country.view.CountryViewSave;
import com.example.bellIntegrator.doc.view.DocViewSave;
import com.example.bellIntegrator.office.view.OfficeViewSave;
import com.example.bellIntegrator.organization.view.OrganizationViewSave;
import com.example.bellIntegrator.response.view.DataView;
import com.example.bellIntegrator.user.view.UserViewListIn;
import com.example.bellIntegrator.user.view.UserViewSave;
import com.example.bellIntegrator.user.view.UserViewUpdate;
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
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    //@Transactional
    //неведомо почему с транзакцией не пашет
    public void allTests() throws Exception {
        this.userSaveGetTest();
        this.fullSavedUserUpdateTest();
        this.lowSavedUserUpdateTest();
        this.userFilterTest();
    }

    @Test
    @Transactional
    public void userSaveGetTest() throws Exception {
        UserViewSave request = getUserFullSave();
        UserViewSave tmp = new UserViewSave();
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.result").value("success"))
                .andDo(mvcResult -> {
                    this.mockMvc.perform(get("/api/user/1"))
                            .andExpect(jsonPath("$.data.firstName").value(request.firstName))
                            .andExpect(jsonPath("$.data.citizenshipName").value("Russia"))
                            .andExpect(jsonPath("$.data.docName").value(request.docName));
                });

        //wrong get
        this.mockMvc.perform(get("/api/user/1000"))
                .andExpect(jsonPath("$.error").value("answer is empty"));

        //wrong Save
        tmp.officeId = request.officeId;
        request.officeId = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("officeId is required field"));
        request.officeId = tmp.officeId;

        tmp.firstName = request.firstName;
        request.firstName = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("firstName is required field"));
        request.firstName = "pqowiepqiwpeiqwepqiwpeoiqpweoip";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("firstName max size 30"));
        request.firstName = tmp.firstName;

        tmp.secondName = request.secondName;
        request.secondName = "pqowiepqiwpeiqwepqiwpeoiqpweoip";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("secondName max size 30"));
        request.secondName = tmp.secondName;

        tmp.middleName = request.middleName;
        request.middleName = "pqowiepqiwpeiqwepqiwpeoiqpweoip";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("middleName max size 30"));
        request.middleName = tmp.middleName;

        tmp.position = request.position;
        request.position = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("position is required field"));
        request.position = "pqowiepqiwpeiqwepqiwpeoiqpweoipsdufhisudhfihsudhfisuhfdishf";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("position max size 50"));
        request.position = tmp.position;

        tmp.phone = request.phone;
        request.phone = "1231231321231231";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("phone max size 15"));
        request.phone = tmp.phone;

        tmp.docName = request.docName;
        request.docName = "wahfoihorqqqqqqqqqqwqwqwqwqwqfabksvbsdkvbaisgcditfUSYcdgoervpeiivbuoaviuwibydvwvkdjshuvbrlvkzjdbfvou" +
                "wahfoihorqqqqqqqqqqwqwqwqwqwqfabksvbsdkvbaisgcditfUSYcdgoervpeiivbuoaviuwibydvwvkdjshuvbrlvkzjdbfvoud";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("docName max size 200"));
        request.docName = tmp.docName;

        tmp.docNumber = request.docNumber;
        request.docNumber = "1231231321231231";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("docNumber max size 15"));
        request.docNumber = tmp.docNumber;
    }

    @Test
    @Transactional
    public void fullSavedUserUpdateTest() throws Exception {
        UserViewSave requestSave = getUserFullSave();
        requestSave.firstName = "Вася";
        String requestJson = mapper.writeValueAsString(requestSave);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson));

        //получаем id сохраненного юзера
        UserViewListIn uvli = new UserViewListIn();
        uvli.officeId = 1L;
        uvli.firstName = "Вася";
        String uvliJson = mapper.writeValueAsString(uvli);
        MvcResult mvcRez = this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(uvliJson))
                .andReturn();
        String resultString = mvcRez.getResponse().getContentAsString();
        DataView dataView = mapper.readValue(resultString, DataView.class);
        List<Object> listOuts = (List<Object>) dataView.data;
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>)listOuts.get(0);
        //update user by taken id
        UserViewUpdate request = new UserViewUpdate();
        request.id = Long.valueOf((Integer)linkedHashMap.get("id"));
        request.officeId = 1L;
        request.firstName = "Александр";
        request.secondName = "Александров";
        request.middleName = "Александрович";
        request.position = "justWorker";
        request.phone = "444444";
        request.docName = "Какое-то свидетельство";
        request.docNumber = "6303123456";
        request.docDate = Date.valueOf("2002-12-11");
        request.citizenshipCode = 840;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.result").value("success"))
                .andDo(mvcResult -> {
                    this.mockMvc.perform(get("/api/user/" + linkedHashMap.get("id")))
                            .andExpect(jsonPath("$.data.firstName").value(request.firstName))
                            .andExpect(jsonPath("$.data.citizenshipName").value("USA"))
                            //.andExpect(jsonPath("$.data.docDate").value(request.docDate))
                            .andExpect(jsonPath("$.data.docNumber").value(request.docNumber));
                });

        //wrong update requests
        request.id = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("Id is required field"));
        request.id = 1L;

        request.firstName = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("firstName is required field"));
        request.firstName = "qiuwheiquhweiquwehiquwehqiquwhe";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("firstName max size 30"));
        request.firstName = "Александр";

        request.secondName = "qiuwheiquhweiquwehiquwehqiquwhe";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("secondName max size 30"));
        request.secondName = "Александров";

        request.middleName = "qiuwheiquhweiquwehiquwehqiquwhe";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("middleName max size 30"));
        request.middleName = "Александрович";

        request.position = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("position is required field"));
        request.position = "qiuwheiquhweiquwehiquwqdhiqowhdoqwoqiwdhqowidhoqihehqiquwhe";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("position max size 50"));
        request.position = "justWorker";

        request.phone = "1231231231231231";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("phone max size 15"));
        request.phone = "444444";

        request.docName = "qiuwheiquhweiquwehiquwehqiquwheqiuwheiquhweiquwehiquwehqiquwheqiuwheiquhweiquwehiquwehqiquwhe" +
                "qiuwheiquhweiquwehiquwehqiquwheqiuwheiquhweiquwehiquwehqiquwheqiuwheiquhweiquwehiquwehqiquwheqiuwheiquhweiquwehiquwehqiquwhe";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("docName max size 200"));
        request.docName = "Passport";

        request.docNumber = "1231231231231231";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("docNumber max size 15"));
        request.docNumber = "6303123456";
    }

    @Test
    @Transactional
    public void lowSavedUserUpdateTest() throws Exception {
        UserViewSave requestS = getUserLowSave();
        requestS.firstName = "Кирюша";
        String requestJson = mapper.writeValueAsString(requestS);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson));

        UserViewListIn uvli = new UserViewListIn();
        uvli.officeId = 1L;
        uvli.firstName = "Кирюша";
        String uvliJson = mapper.writeValueAsString(uvli);
        MvcResult mvcRez = this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(uvliJson))
                .andReturn();
        String resultString = mvcRez.getResponse().getContentAsString();
        DataView dataView = mapper.readValue(resultString, DataView.class);
        List<Object> listOuts = (List<Object>) dataView.data;
        LinkedHashMap<String, Object> linkedHashMap = (LinkedHashMap<String, Object>)listOuts.get(0);

        UserViewUpdate request = new UserViewUpdate();
        request.id = Long.valueOf((Integer)linkedHashMap.get("id"));
        request.officeId = 1L;
        request.firstName = "Александр";
        request.secondName = "Александров";
        request.middleName = "Александрович";
        request.position = "justWorker";
        request.phone = "444444";
        request.docName = "Some thing";
        request.docNumber = "6303123456";
        request.docDate = Date.valueOf("2002-12-11");
        request.citizenshipCode = 840;

        //wrong docName
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("wrong docName"));

        //correct docName
        request.docName = "Паспорт гражданина Российской Федерации";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.result").value("success"))
                .andDo(mvcResult -> {
                    this.mockMvc.perform(get("/api/user/" + linkedHashMap.get("id")))
                            .andExpect(jsonPath("$.data.firstName").value(request.firstName))
                            .andExpect(jsonPath("$.data.citizenshipName").value("USA"))
                            .andExpect(jsonPath("$.data.docNumber").value(request.docNumber));
                });


    }

    @Test
    @Transactional
    public void userFilterTest () throws Exception {
        UserViewSave requestS =  getUserFullSave();
        String requestJson = mapper.writeValueAsString(requestS);
        this.mockMvc.perform(post("/api/user/save").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(mvcResult -> {
                    this.mockMvc.perform(get("/api/user/1"))
                            .andExpect(jsonPath("$.data.firstName").value(requestS.firstName));
                });

        //only officeId filter
        UserViewListIn request = new UserViewListIn();
        request.officeId = requestS.officeId;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.data[0].firstName").value(requestS.firstName));

        //full param filter
        request.firstName = requestS.firstName;
        request.secondName = requestS.secondName;
        request.middleName = requestS.middleName;
        request.position = requestS.position;
        request.docCode = requestS.docCode;
        request.citizenshipCode = requestS.citizenshipCode;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.data[0].position").value(requestS.position))
                .andExpect(jsonPath("$.data[0].firstName").value(requestS.firstName));

        //user filter wrong fields
        request.officeId = null;
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("officeId is required field"));
        request.officeId = requestS.officeId;

        request.firstName = "qowheoqwhoequwheouqhwoehqowheoquwheoqwh";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("firstName max size 30"));
        request.firstName = requestS.firstName;

        request.secondName = "qowheoqwhoequwheouqhwoehqowheoquwheoqwh";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("secondName max size 30"));
        request.secondName = requestS.secondName;

        request.middleName = "qowheoqwhoequwheouqhwoehqowheoquwheoqwh";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("middleName max size 30"));
        request.middleName = requestS.middleName;

        request.position = "qowheoqwhoequwheouqhwoehqowheoquwheoqwhqouebcoqebucoebqebc";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/user/list").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(jsonPath("$.error").value("position max size 50"));
        request.position = requestS.position;
    }


    private UserViewSave getUserFullSave () throws Exception {
        saveOff();
        saveCountry();
        saveDoc();
        UserViewSave request = new UserViewSave();
        request.officeId = 1L;
        request.firstName = "Алексей";
        request.secondName = "Алексеев";
        request.middleName = "Алексеевич";
        request.position = "justWorker";
        request.phone = "444444";
        request.docCode = 21;
        request.docName = "Паспорт гражданина Российской Федерации";
        request.docNumber = "6303123123";
        request.docDate = Date.valueOf("2006-10-11");
        request.citizenshipCode = 643;
        request.isIdentified = true;
        return  request;
    }

    private UserViewSave getUserLowSave () throws Exception {
        saveOff();
        saveCountry();
        saveDoc();
        UserViewSave request = new UserViewSave();
        request.officeId = 1L;
        request.firstName = "Александр";
        request.secondName = "Александров";
        request.middleName = "Александрович";
        request.position = "justWorker";
        request.phone = "444444";
        request.isIdentified = true;
        return  request;
    }

    private OfficeViewSave getOfficeSave () throws Exception {
        OfficeViewSave request = new OfficeViewSave();
        request.orgId = 1L;
        request.name = "Some office";
        request.phone = "666666";
        return request;
    }

    private void saveCountry () throws Exception {
        CountryViewSave request = new CountryViewSave();
        request.code = 643;
        request.name = "Russia";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson));

        request.code = 840;
        request.name = "USA";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/countries/add").contentType(MediaType.APPLICATION_JSON).content(requestJson));
    }

    private void saveDoc () throws Exception {
        DocViewSave request = new DocViewSave();
        request.code = 21;
        request.name = "Паспорт гражданина Российской Федерации";
        String requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson));

        request.code = 23;
        request.name = "Свидетельство о рождении, выданное уполномоченным органом иностранного государства";
        requestJson = mapper.writeValueAsString(request);
        this.mockMvc.perform(post("/api/docs/add").contentType(MediaType.APPLICATION_JSON).content(requestJson));
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