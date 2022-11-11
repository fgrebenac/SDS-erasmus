package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "app_comment")
public class AppComment {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String content;

    @OneToOne()
    @JoinColumn(name="user_id")
    private AppUser user;

    @OneToOne()
    @JoinColumn(name="thread_id")
    private Thread thread;

    @OneToOne()
    @JoinColumn(name="app_comment_id")
    private AppComment comment;

}
