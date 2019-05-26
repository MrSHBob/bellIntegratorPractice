package com.example.bellIntegrator.user.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.country.controller.CountryController;
import com.example.bellIntegrator.country.view.CountryViewSave;
import com.example.bellIntegrator.doc.controller.DocController;
import com.example.bellIntegrator.doc.view.DocViewSave;
import com.example.bellIntegrator.office.controller.OfficeController;
import com.example.bellIntegrator.office.view.OfficeViewSave;
import com.example.bellIntegrator.organization.controller.OrganizationController;
import com.example.bellIntegrator.organization.view.OrganizationViewSave;
import com.example.bellIntegrator.user.view.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
public class UserControllerTest {

    @Autowired
    private CountryController countryController;
    @Autowired
    private DocController docController;
    @Autowired
    private OrganizationController organizationController;
    @Autowired
    private OfficeController officeController;
    @Autowired
    private UserController userController;

    @Test
    public void userTest() {
        //Добавление записи в таблицу для стран.
        CountryViewSave cvs = new CountryViewSave();
        cvs.code = 643;
        cvs.name = "Russia";
        countryController.add(cvs);

        //Добавление в таблицу ддл перечня документов.
        DocViewSave dvs = new DocViewSave();
        dvs.code = 21;
        dvs.name = "Паспорт гражданина Российской Федерации";
        docController.add(dvs);

        //Добавление организации в таблицу.
        OrganizationViewSave orgvs = new OrganizationViewSave();
        orgvs.isActive = true;
        orgvs.address = "ул.Цюрупы, 16";
        orgvs.fullName = "организация ООО \"Некая организация 1\"";
        orgvs.name = "Некая организация 1";
        orgvs.inn = "1234567890";
        orgvs.kpp = "1234AZ01";
        organizationController.save(orgvs);

        //Добавление офиса в таблицу.
        OfficeViewSave ovs = new OfficeViewSave();
        ovs.orgId = 1L;
        ovs.name = "Some office";
        officeController.save(ovs);

//Пришлось всю ленивую инициализацию поменять на жадную, хз как исправить.
        UserViewSave uvs = new UserViewSave();
        uvs.officeId = 1L;
        uvs.firstName = "Евгений";
        uvs.position = "тестировщик";
        uvs.docCode = 21;
        uvs.docNumber = "6303123123";
        uvs.docDate = Date.valueOf("2006-10-11");
        uvs.citizenshipCode = 643;
        uvs.isIdentified = true;
        userController.save(uvs);
        UserViewGet uvg = userController.userById(1L);
        assertEquals(uvs.firstName, uvg.firstName);
        assertEquals(dvs.name, uvg.docName);
        assertEquals(uvg.citizenshipName, cvs.name);

        UserViewUpdate uvu = new UserViewUpdate();
        uvu.id = 1L;
        uvu.firstName = "Вася";
        uvu.position = "менеджер";
        userController.update(uvu);
        UserViewListIn uvli = new UserViewListIn();
        uvli.officeId = 1L;
        uvli.firstName = "Вася";
        uvli.position = "менеджер";
        uvli.docCod = uvs.docCode;
        uvli.citizenshipCode = uvs.citizenshipCode;
        UserViewListOut uvlo = userController.list(uvli).get(0);
        assertEquals(uvli.officeId, uvlo.id);
        assertEquals(uvlo.firstName, uvli.firstName);
        assertEquals(uvlo.position, uvli.position);
    }
}