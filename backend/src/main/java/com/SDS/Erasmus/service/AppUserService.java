package com.SDS.Erasmus.service;

import com.SDS.Erasmus.domain.AppUser;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AppUserService {

    List<AppUser> listAll();
}
