package com.SDS.Erasmus.service.impl;

import com.SDS.Erasmus.dao.AppUserRepository;
import com.SDS.Erasmus.domain.AppUser;
import com.SDS.Erasmus.service.AppUserService;
import com.SDS.Erasmus.service.EntityMissingException;
import com.SDS.Erasmus.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppUserServiceJpa implements AppUserService {

    //simple email regex
    private static final String VALID_EMAIL_ADDRESS_REGEX = "^.+@.+\\..+$";

    @Autowired
    private AppUserRepository appUserRepo;

    @Override
    public List<AppUser> listAll(){
        return appUserRepo.findAll();
    }

    @Override
    public AppUser createUser(AppUser user) {
        validate(user);

        if (appUserRepo.countByEmail(user.getEmail()) > 0) {
            throw new RequestDeniedException("User with email \"" + user.getEmail() + "\" already exists");
        }

        return appUserRepo.save(user);
    }

    @Override
    public AppUser updateUser(AppUser user) {
        validate(user);

        UUID userId = user.getId();
        if (!appUserRepo.existsById(userId))
            throw new EntityMissingException(AppUser.class, userId);
        if (appUserRepo.existsByEmailAndIdNot(user.getEmail(), userId))
            throw new RequestDeniedException(
                    "Student with Email " + user.getEmail() + " already exists"
            );
        return appUserRepo.save(user);

    }

    @Override
    public AppUser deleteUser(UUID userId) {
        AppUser user = fetch(userId);
        appUserRepo.delete(user);
        return user;
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        Assert.notNull(email, "EMAIL must be given");
        return appUserRepo.findByEmail(email);
    }

    @Override
    public UUID logIn(AppUser user) {
        Optional<AppUser> optionalUser = findByEmail(user.getEmail());
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            return optionalUser.get().getId();
        }
        throw new RequestDeniedException("Email and password do not match");
    }

    @Override
    public Optional<AppUser> findById(UUID userId) {
        return appUserRepo.findById(userId);
    }

    @Override
    public AppUser fetch(UUID userId) {
        return findById(userId).orElseThrow(
                () -> new EntityMissingException(AppUser.class, userId)
        );
    }

    private void validate(AppUser user){
        Assert.notNull(user,"User object must ge given");
        String email = user.getEmail();
        Assert.hasText(email, "Email must be given");
        Assert.isTrue(email.matches(VALID_EMAIL_ADDRESS_REGEX), "Email must be in valid format");
        Assert.notNull(user.getFirstName(), "User must have a first name");
        Assert.notNull(user.getLastName(), "User must have a last name");
        Assert.notNull(user.getPassword(), "User must have a password");
//        Assert.notNull(user.getCountry(), "User must have a country set");
        Assert.isNull(user.getToken(), "User must not have a token set");

    }


}
