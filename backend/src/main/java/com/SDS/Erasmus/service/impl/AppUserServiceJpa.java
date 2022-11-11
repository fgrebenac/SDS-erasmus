package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.AppUserRepository;
import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserServiceJpa implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepo;

    @Override
    public List<AppUser> listAll(){
        return appUserRepo.findAll();
    }
}
