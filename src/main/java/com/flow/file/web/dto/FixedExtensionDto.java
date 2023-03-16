package com.flow.file.web.dto;

import com.flow.file.biz.entity.FixedExtension;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FixedExtensionDto {
    private long id;
    private String name;
    private boolean use;

    @Builder
    public FixedExtensionDto(long id, String name, boolean use) {
        this.id = id;
        this.name = name;
        this.use = use;
    }

    public FixedExtension toEntity() {
        return FixedExtension.builder()
            .id(id)
            .name(name)
            .use(use)
            .build();
    }

}
