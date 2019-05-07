package com.example.bellIntegrator.doc.controller;

import com.example.bellIntegrator.additionalLogic.view.SuccessView;
import com.example.bellIntegrator.doc.service.DocService;
import com.example.bellIntegrator.doc.view.DocView;
import com.example.bellIntegrator.doc.view.DocViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocController {

    private final DocService docService;

    @Autowired
    public DocController (DocService docService) {
        this.docService = docService;
    }

    @GetMapping
    public List<DocView> countries () {
        List<DocView> views = docService.docs();
        return views;
    }

    @PostMapping("/add")                                                    //temporary method
    public SuccessView add (@RequestBody DocViewSave view) {
        docService.add(view);
        SuccessView success = new SuccessView();
        return  success;
    }

}
