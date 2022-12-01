package com.SDS.Erasmus.rest;

import com.SDS.Erasmus.domain.Country;
import com.SDS.Erasmus.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("")
    public List<Country> listCountries() {
        return countryService.listAll();
    }


}
