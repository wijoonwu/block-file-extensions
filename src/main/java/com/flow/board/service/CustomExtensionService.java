package com.flow.board.service;

import com.flow.board.repository.CustomExtensionRepository;
import com.flow.board.web.dto.CustomExtensionDto;
import com.flow.board.entity.CustomExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CustomExtensionService {

    private final CustomExtensionRepository customExtensionRepository;

    protected static final String EXISTING_EXTENSION_MSG = "이미 추가된 확장자 입니다.";
    protected static final String MAX_SIZE_EXCEEDED_MSG = "200개를 초과하여 등록할 수 없습니다.";
    protected static final String MAX_LENGTH_EXCEEDED_MSG = "20글자를 초과할 수 없습니다.";
    protected static final String ADD_SUCCESS_MSG = "추가 되었습니다.";
    protected static final String DELETE_SUCCESS_MSG = "삭제되었습니다";

    @Transactional(readOnly = true)
    public List<CustomExtension> readAll() {
        return customExtensionRepository.findAll();
    }

    public String createCustomExtension(CustomExtensionDto customExtensionDto) {
        String name = customExtensionDto.getName();

        if (customExtensionRepository.findByName(name).isPresent()) {
            return EXISTING_EXTENSION_MSG;
        }
        if (customExtensionRepository.findAll().size() > CustomExtension.MAX_SIZE) {
            return MAX_SIZE_EXCEEDED_MSG;
        }

        if (customExtensionDto.getName().length() > CustomExtension.MAX_LENGTH ) {
            return MAX_LENGTH_EXCEEDED_MSG;
        }

        CustomExtension customExtension = customExtensionDto.toEntity();
        customExtensionRepository.save(customExtension);
        return ADD_SUCCESS_MSG;
    }

    public String deleteCustomExtension(CustomExtensionDto customExtensionDto) {
        String name = customExtensionDto.getName();
        customExtensionRepository.deleteByName(name);
        return DELETE_SUCCESS_MSG;
    }
}
