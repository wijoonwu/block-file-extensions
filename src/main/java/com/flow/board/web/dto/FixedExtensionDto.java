package com.flow.board.web.dto;

import com.flow.board.entity.FixedExtension;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class FixedExtensionDto {
    private long id;

    private String name;

    private boolean use;
    public FixedExtension toEntity(){
        return new FixedExtension(id, name, use);
    }
}
