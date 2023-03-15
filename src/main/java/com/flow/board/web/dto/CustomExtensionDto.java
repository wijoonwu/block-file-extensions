package com.flow.board.web.dto;

import com.flow.board.web.entity.CustomExtension;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CustomExtensionDto {
    private long id;

    private String name;

    public CustomExtension toEntity(){
        return new CustomExtension(id, name);
    }
}
