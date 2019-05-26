package com.example.bellIntegrator.organization.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.organization.model.Organization;
import com.example.bellIntegrator.organization.view.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
public class OrganizationControllerTest {

    @Autowired
    private OrganizationController organizationController;

    @Test
    public void organizationTest () {
        OrganizationViewSave ovs = new OrganizationViewSave();
        ovs.isActive = true;
        ovs.address = "ул.Цюрупы, 16";
        ovs.fullName = "организация ООО \"Некая организация 1\"";
        ovs.name = "Некая организация 1";
        ovs.inn = "1234567890";
        ovs.kpp = "1234AZ01";
        organizationController.save(ovs);
        OrganizationView orgView = organizationController.orgById(1L);
        assertEquals(ovs.name, orgView.name);
        assertEquals(ovs.fullName, orgView.fullName);
        assertEquals(ovs.inn, orgView.inn);

        OrganizationViewUpdate ovu = new OrganizationViewUpdate();
        ovu.id = 1L;
        ovu.address = "ул.Цюрупы, 17";
        ovu.fullName = "организация ООО \"Некая организация 2\"";
        ovu.name = "Некая организация 2";
        ovu.inn = "0987654321";
        ovu.kpp = "1234AZ01";
        organizationController.update(ovu);
        OrganizationViewListIn ovli = new OrganizationViewListIn();
        ovli.name = "2";
        ovli.inn = ovu.inn;
        List<OrganizationViewListOut> orgViews = organizationController.list(ovli);
        OrganizationViewListOut ovlo = orgViews.get(0);
        assertEquals(ovu.id, ovlo.id);
        assertEquals(ovu.name, ovlo.name);
    }
}