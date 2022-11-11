package com.SDS.Erasmus;

import com.SDS.Erasmus.domain.Country;
import com.SDS.Erasmus.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/app-countries")
    public List<Country> listCountries() {
        return countryService.listAll();
    }


}
