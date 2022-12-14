package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "thread")
public class Thread {

    @Id
    @Type(type = "pg-uuid")
    @Column(name = "id", columnDefinition = "uuid", insertable = false)
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "content", nullable = false)
    private String content;

    @OneToOne()
    @JoinColumn(name="user_id")
    private AppUser user;

    @OneToOne()
    @JoinColumn(name="category_id")
    private Category category;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }



}
