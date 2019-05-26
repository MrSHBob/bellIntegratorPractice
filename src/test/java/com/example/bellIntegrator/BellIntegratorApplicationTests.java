package com.example.bellIntegrator;

import com.example.bellIntegrator.country.controller.CountryController;
import com.example.bellIntegrator.country.controller.CountryControllerTest;
import com.example.bellIntegrator.country.view.CountryView;
import com.example.bellIntegrator.country.view.CountryViewSave;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest (classes = BellIntegratorApplication.class)
//@TestPropertySource("/test.properties")
//@AutoConfigureMockMvc
public class BellIntegratorApplicationTests {

	@Autowired
	private CountryController countryController;

	@Test
	public void countryTest () {
		CountryViewSave cvs = new CountryViewSave();
		cvs.code = 643;
		cvs.name = "Russia";
		countryController.add(cvs);
        List<CountryView> list = countryController.countries();
        CountryView countryView = list.get(0);
		assertEquals(cvs.code, countryView.code);
        assertEquals(cvs.name, countryView.name);
	}
}
