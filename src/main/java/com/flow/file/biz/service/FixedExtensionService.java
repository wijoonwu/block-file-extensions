package com.flow.file.biz.service;

import com.flow.file.biz.entity.FixedExtension;
import com.flow.file.biz.repository.FixedExtensionRepository;
import com.flow.file.web.dto.FixedExtensionDto;
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

    public static final String EXTENSION_IN_USE = "사용상태로 변경되었습니다.";
    public static final String EXTENSION_NOT_IN_USE = "미사용 상태로 변경 되었습니다.";
    public static final String EXTENSION_NOT_FOUND = "확장자를 찾을 수 없습니다.";

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
