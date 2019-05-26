package com.example.bellIntegrator.office.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.office.view.*;
import com.example.bellIntegrator.organization.controller.OrganizationController;
import com.example.bellIntegrator.organization.view.OrganizationViewSave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
public class OfficeControllerTest {

    @Autowired
    private OfficeController officeController;

    @Autowired
    private OrganizationController organizationController;

    @Test
    public void officeTest () {
        OrganizationViewSave orgvs = new OrganizationViewSave();
        orgvs.isActive = true;
        orgvs.address = "ул.Цюрупы, 16";
        orgvs.fullName = "организация ООО \"Некая организация 1\"";
        orgvs.name = "Некая организация 1";
        orgvs.inn = "1234567890";
        orgvs.kpp = "1234AZ01";
        organizationController.save(orgvs);

        OfficeViewSave ovs = new OfficeViewSave();
        ovs.orgId = 1L;
        ovs.name = "Some office";
        officeController.save(ovs);
        OfficeViewGet ovg = officeController.officeById(1L);
        assertEquals(ovs.name, ovg.name);

        OfficeViewUpdate ovu = new OfficeViewUpdate();
        ovu.id = 1L;
        ovu.name = "Updated office";
        ovu.address = "ул.Лунина, 7";
        ovu.phone = "555555";
        officeController.update(ovu);
        OfficeViewListIn ovli = new OfficeViewListIn();
        ovli.orgId = 1L;
        ovli.name = ovu.name;
        ovli.phone = ovu.phone;
        OfficeViewListOut ovlo = officeController.officeFilter(ovli).get(0);
        assertEquals(ovu.id, ovlo.id);
        assertEquals(ovu.name, ovlo.name);
    }
}