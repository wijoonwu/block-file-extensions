package com.flow.board.web.dto;

import com.flow.board.entity.CustomExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CustomExtensionDto {
    private long id;
    private String name;

    @Builder
    public CustomExtensionDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomExtension toEntity() {
        return CustomExtension.builder()
            .id(id)
            .name(name)
            .build();
    }
}
