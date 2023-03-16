package com.flow.board.service;

import com.flow.board.entity.CustomExtension;
import com.flow.board.repository.CustomExtensionRepository;
import com.flow.board.web.dto.CustomExtensionDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomExtensionServiceTest {

    @InjectMocks
    private CustomExtensionService customExtensionService;

    @Mock
    private CustomExtensionRepository customExtensionRepository;

    private CustomExtensionDto customExtensionDto;

    @BeforeEach
    public void setUp() {
        customExtensionDto = CustomExtensionDto.builder()
            .name("test")
            .build();
    }

    @Test
    @DisplayName("커스텀 확장자가 성공적으로 추가됩니다")
    public void createCustomExtension_addsSuccessfully() {
        when(customExtensionRepository.findByName(customExtensionDto.getName())).thenReturn(
            Optional.empty());
        when(customExtensionRepository.findAll()).thenReturn(List.of());
        when(customExtensionRepository.save(any(CustomExtension.class))).thenReturn(
            customExtensionDto.toEntity());

        String result = customExtensionService.createCustomExtension(customExtensionDto);

        assertThat(result).isEqualTo(CustomExtensionService.ADD_SUCCESS_MSG);
    }

    @Test
    @DisplayName("커스텀 확장자가 이미 존재합니다")
    public void createCustomExtension_alreadyExists() {
        when(customExtensionRepository.findByName(customExtensionDto.getName())).thenReturn(
            Optional.of(customExtensionDto.toEntity()));

        String result = customExtensionService.createCustomExtension(customExtensionDto);

        assertThat(result).isEqualTo(CustomExtensionService.EXISTING_EXTENSION_MSG);
    }

    @Test
    @DisplayName("커스텀 확장자 최대 개수를 초과합니다")
    public void createCustomExtension_maxSizeExceeded() {
        when(customExtensionRepository.findByName(customExtensionDto.getName())).thenReturn(
            Optional.empty());
        List<CustomExtension> maxSizeExtensions = IntStream.rangeClosed(1,
                CustomExtension.MAX_SIZE + 1)
            .mapToObj(i -> CustomExtension.builder().name("ext" + i).build())
            .collect(Collectors.toList());
        when(customExtensionRepository.findAll()).thenReturn(maxSizeExtensions);

        String result = customExtensionService.createCustomExtension(customExtensionDto);

        assertThat(result).isEqualTo(CustomExtensionService.MAX_SIZE_EXCEEDED_MSG);
    }

    @Test
    @DisplayName("커스텀 확장자 이름의 최대 길이를 초과합니다")
    public void createCustomExtension_maxLengthExceeded() {
        customExtensionDto = CustomExtensionDto.builder()
            .name("a".repeat(CustomExtension.MAX_LENGTH + 1))
            .build();

        String result = customExtensionService.createCustomExtension(customExtensionDto);

        assertThat(result).isEqualTo(CustomExtensionService.MAX_LENGTH_EXCEEDED_MSG);
    }

    @Test
    @DisplayName("커스텀 확장자가 성공적으로 삭제됩니다")
    public void deleteCustomExtension_deletesSuccessfully() {
        doNothing().when(customExtensionRepository).deleteByName(customExtensionDto.getName());

        String result = customExtensionService.deleteCustomExtension(customExtensionDto);
        assertThat(result).isEqualTo(CustomExtensionService.DELETE_SUCCESS_MSG);
    }
}

