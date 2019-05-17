package com.example.bellIntegrator.doc.controller;

import com.example.bellIntegrator.doc.service.DocService;
import com.example.bellIntegrator.doc.view.DocView;
import com.example.bellIntegrator.doc.view.DocViewSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Контроллер для обработки запросов по Перечню документов
 */
@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocController {

    private final DocService docService;

    @Autowired
    public DocController (DocService docService) {
        this.docService = docService;
    }

    /**
     * Метод на запрос перечня документов
     */
    @GetMapping
    public List<DocView> docs () {
        List<DocView> views = docService.docs();
        return views;
    }

    /**
     * Метод на добавление нового документа в перечень
     */
    @PostMapping("/add")                                                    //temporary method
    public void add (@RequestBody DocViewSave view) {
        docService.add(view);
    }
}
