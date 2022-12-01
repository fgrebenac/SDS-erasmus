package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @Type(type = "pg-uuid")
    @Column(name = "id", columnDefinition = "uuid", insertable = false)
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "home_country_id", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID homeCountryID;

    private String token;

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UUID getHomeCountryID() {
        return homeCountryID;
    }

    public String getToken() {
        return token;
    }
}
