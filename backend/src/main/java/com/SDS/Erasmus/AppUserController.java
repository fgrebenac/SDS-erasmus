package com.SDS.Erasmus;

import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("/app-users")
    public List<AppUser> listAppUsers() {
        return appUserService.listAll();
    }


}
