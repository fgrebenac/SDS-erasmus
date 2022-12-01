package com.SDS.Erasmus.dao;


import com.SDS.Erasmus.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    int countByEmail(String email);

    Boolean existsByEmailAndIdNot(String email, UUID id);

    Optional<AppUser> findByEmail(String email);


}
