package com.example.bellIntegrator.office.service;

import com.example.bellIntegrator.office.view.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface OfficeService {

    void add (@Valid OfficeViewSave office);

    void update (@Valid OfficeViewUpdate view);

    List<OfficeViewListOut> officeByOrg(Long orgId);

    OfficeViewGet officeById(Long id);
}
