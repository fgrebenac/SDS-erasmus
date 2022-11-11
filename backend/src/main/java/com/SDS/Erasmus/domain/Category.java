package com.SDS.Erasmus.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    @OneToOne()
    @JoinColumn(name="category_id")
    private Category categoryID;

}
