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
    @Column(name = "last_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String email;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String password;

    @OneToOne()
    @JoinColumn(name="home_country_id")
    private Country homeCountryID;

    private String token;

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setHomeCountryID(Country homeCountryID) {
        this.homeCountryID = homeCountryID;
    }

    public Country getHomeCountryID() {
        return homeCountryID;
    }

    public String getToken() {
        return token;
    }
}
