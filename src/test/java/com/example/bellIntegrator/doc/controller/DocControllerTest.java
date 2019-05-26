package com.example.bellIntegrator.doc.controller;

import com.example.bellIntegrator.BellIntegratorApplication;
import com.example.bellIntegrator.doc.view.DocView;
import com.example.bellIntegrator.doc.view.DocViewSave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BellIntegratorApplication.class)
public class DocControllerTest {

    @Autowired
    private DocController docController;

    @Test
    public void docTest () {
        DocViewSave dvs = new DocViewSave();
        dvs.code = 21;
        dvs.name = "Паспорт гражданина Российской Федерации";
        docController.add(dvs);
        List<DocView> list = docController.docs();
        DocView docView = list.get(0);
        assertEquals(dvs.code, docView.code);
        assertEquals(dvs.name, docView.name);
    }

}