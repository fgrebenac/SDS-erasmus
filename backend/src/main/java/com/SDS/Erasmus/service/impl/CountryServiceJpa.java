package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.CountryRepository;
import com.SDS.Erasmus.domain.Country;
import com.SDS.Erasmus.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceJpa implements CountryService {

    @Autowired
    private CountryRepository countryRepo;

    @Override
    public List<Country> listAll(){
        return countryRepo.findAll();
    }
}
