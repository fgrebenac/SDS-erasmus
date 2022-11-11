package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToOne()
    @JoinColumn(name="home_country_id")
    private Country homeCountryID;

    private String token;

}
