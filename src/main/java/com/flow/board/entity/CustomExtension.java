package com.flow.board.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOM_EXTENSION", uniqueConstraints = { @UniqueConstraint(columnNames = "name")
})
public class CustomExtension {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 20)
    private String name;

    public static final int MAX_SIZE = 200;

    public static final int MAX_LENGTH = 20;


}
