package com.flow.board.service;


import com.flow.board.repository.FixedExtensionRepository;
import com.flow.board.web.dto.FixedExtensionDto;
import com.flow.board.web.entity.FixedExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class FixedExtensionService {
    private final FixedExtensionRepository fixedExtensionRepository;

    @Transactional(readOnly = true)
    public List<FixedExtension> readAll() {
       return fixedExtensionRepository.findAll();
    }

    public String updateFixedExtension(FixedExtensionDto fixedExtensionDto) {
        String name = fixedExtensionDto.getName();
        FixedExtension fixedExtension = fixedExtensionRepository.findByName(name);
        fixedExtension.updateUse();
        return "사용 상태가 변경되었습니다.";
    }
}
