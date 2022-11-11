package com.SDS.Erasmus.dao;


import com.SDS.Erasmus.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {

}
