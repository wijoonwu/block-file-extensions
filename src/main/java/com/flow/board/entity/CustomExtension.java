package com.flow.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOM_EXTENSION", uniqueConstraints = { @UniqueConstraint(columnNames = "name")
})
public class CustomExtension {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    public static final int MAX_SIZE = 200;


}
