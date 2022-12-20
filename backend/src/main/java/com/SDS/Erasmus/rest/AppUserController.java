package com.SDS.Erasmus.rest;

import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping("")
    public List<AppUser> listAppUsers() {
        return appUserService.listAll();
    }

    @GetMapping("/{id}")
    public AppUser getAppUser(@PathVariable("id") UUID id) {
        return appUserService.fetch(id);
    }

    @PostMapping("")
    public ResponseEntity<AppUser> createAppUser(@RequestBody AppUser user) {
        AppUser saved = appUserService.createUser(user);
        return ResponseEntity.created(URI.create("/users/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public AppUser updateAppUser(@PathVariable("id") UUID id, @RequestBody AppUser user) {
        if (!user.getId().equals(id))
            throw new IllegalArgumentException("AppUser ID must be preserved");
        return appUserService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public AppUser deleteAppUser(@PathVariable("id") UUID userId) {
        return appUserService.deleteUser(userId);
    }

    //simple log in method, jwt and encryption may be added later
    @PostMapping("/log-in")
    public AppUser AppUser(@RequestBody AppUser user) {
        return appUserService.logIn(user);
    }


}
