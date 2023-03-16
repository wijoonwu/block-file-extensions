package com.flow.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "FIXED_EXTENSION")
public class FixedExtension {

    @Id
    private long id;

    @Column(unique = true, length = 20)
    private String name;

    private boolean use = false;

    public void updateUse() {
        this.use = !this.use;
    }
}
