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

    @Transactional(readOnly = true)
    public List<CustomExtension> readAll() {
        return customExtensionRepository.findAll();
    }

    public String createCustomExtension(CustomExtensionDto customExtensionDto) {
        int totalCustomExtensionSize = customExtensionRepository.findAll().size();
        String name = customExtensionDto.getName();

        if (customExtensionRepository.findByName(name).isPresent()) {
            return "이미 추가된 확장자 입니다.";
        }
        if (totalCustomExtensionSize > CustomExtension.MAX_SIZE) {
            return "200개를 초과하여 등록할 수 없습니다.";
        }

        if (customExtensionDto.getName().length() > CustomExtension.MAX_LENGTH ) {
            return "20글자를 초과할 수 없습니다.";
        }

        CustomExtension customExtension = customExtensionDto.toEntity();
        customExtensionRepository.save(customExtension);
        return "추가 되었습니다.";
    }

    public String deleteCustomExtension(CustomExtensionDto customExtensionDto) {
        String name = customExtensionDto.getName();
        customExtensionRepository.deleteByName(name);
        return "삭제되었습니다";
    }
}
