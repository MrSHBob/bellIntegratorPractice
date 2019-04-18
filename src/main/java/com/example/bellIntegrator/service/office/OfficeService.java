package com.example.bellIntegrator.service.office;

import com.example.bellIntegrator.view.OfficeView;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OfficeService {

    void add (@Valid OfficeView office);

    List<OfficeView> offices();
}
