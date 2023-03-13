package com.flow.board.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FIXED_EXTENSION")
public class FixedExtension {

    @Id
    private long id;

    private String name;

    private boolean use;

}
