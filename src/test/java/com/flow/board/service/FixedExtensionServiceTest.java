package com.flow.board.service;

import com.flow.board.entity.FixedExtension;
import com.flow.board.repository.FixedExtensionRepository;
import com.flow.board.web.dto.FixedExtensionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FixedExtensionServiceTest {

    @InjectMocks
    private FixedExtensionService fixedExtensionService;

    @Mock
    private FixedExtensionRepository fixedExtensionRepository;

    private FixedExtensionDto fixedExtensionDto;

    @BeforeEach
    public void setUp() {
        fixedExtensionDto = FixedExtensionDto.builder()
            .name("test")
            .use(false)
            .build();
    }

    @Test
    @DisplayName("모든 고정 확장자를 불러옵니다")
    public void readAll() {
        List<FixedExtension> fixedExtensions = List.of(fixedExtensionDto.toEntity());
        when(fixedExtensionRepository.findAll()).thenReturn(fixedExtensions);

        List<FixedExtension> result = fixedExtensionService.readAll();

        assertThat(result).isEqualTo(fixedExtensions);
    }

    @Test
    @DisplayName("고정 확장자 사용 상태를 업데이트합니다")
    public void updateFixedExtension() {
        when(fixedExtensionRepository.findByName(fixedExtensionDto.getName())).thenReturn(Optional.of(fixedExtensionDto.toEntity()));

        String result = fixedExtensionService.updateFixedExtension(fixedExtensionDto);

        assertThat(result).isEqualTo(FixedExtensionService.EXTENSION_IN_USE);
    }

    @Test
    @DisplayName("존재하지 않는 고정 확장자를 업데이트하려고 합니다")
    public void updateFixedExtension_notFound() {
        when(fixedExtensionRepository.findByName(fixedExtensionDto.getName())).thenReturn(Optional.empty());

        String result = fixedExtensionService.updateFixedExtension(fixedExtensionDto);

        assertThat(result).isEqualTo(FixedExtensionService.EXTENSION_NOT_FOUND);
    }
}
