package com.flow.board.service;

import com.flow.board.repository.FixedExtensionRepository;
import com.flow.board.web.dto.FixedExtensionDto;
import com.flow.board.entity.FixedExtension;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class FixedExtensionService {
    protected final FixedExtensionRepository fixedExtensionRepository;

    protected static final String EXTENSION_IN_USE = "사용상태로 변경되었습니다.";
    protected static final String EXTENSION_NOT_IN_USE = "미사용 상태로 변경 되었습니다.";
    protected static final String EXTENSION_NOT_FOUND = "확장자를 찾을 수 없습니다.";

    @Transactional(readOnly = true)
    public List<FixedExtension> readAll() {
        return fixedExtensionRepository.findAll();
    }

    public String updateFixedExtension(FixedExtensionDto fixedExtensionDto) {
        String name = fixedExtensionDto.getName();
        Optional<FixedExtension> fixedExtension = fixedExtensionRepository.findByName(name);

        return fixedExtension.map(extension -> {
            extension.updateUse();
            return extension.isUse() ? EXTENSION_IN_USE : EXTENSION_NOT_IN_USE;
        }).orElse(EXTENSION_NOT_FOUND);
    }
}
