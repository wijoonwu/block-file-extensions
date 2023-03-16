package com.flow.board.entity;

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

    private String name;

    private String use;

    public void updateUse() {
        if(this.use.equals("false")){
            this.use = "true";
        } else this.use ="false";
    }
}
