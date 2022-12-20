package com.SDS.Erasmus.service;

import com.SDS.Erasmus.domain.AppUser;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppUserService {

    List<AppUser> listAll();

    AppUser createUser(AppUser user);

    AppUser deleteUser(UUID userId);

    AppUser updateUser(AppUser user);

    Optional<AppUser> findById(UUID userId);

    AppUser fetch(UUID userId);

    Optional<AppUser> findByEmail(String email);


    AppUser logIn(AppUser user);
}
