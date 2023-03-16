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
        customExtensionRepository.save(customExtensionDto.toEntity());
        return "추가 되었습니다.";
    }

    public String deleteCustomExtension(long id) {
        customExtensionRepository.deleteById(id);
        return "삭제되었습니다";
    }
}
