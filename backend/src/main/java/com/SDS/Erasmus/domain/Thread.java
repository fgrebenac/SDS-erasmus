package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "thread")
public class Thread {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @OneToOne()
    @JoinColumn(name="user_id")
    private AppUser user;

    @OneToOne()
    @JoinColumn(name="category_id")
    private Category category;

}
