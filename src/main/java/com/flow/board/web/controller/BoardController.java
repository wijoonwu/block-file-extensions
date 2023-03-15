package com.flow.board.web.controller;

import com.flow.board.repository.CustomExtensionRepository;
import com.flow.board.repository.FixedExtensionRepository;
import com.flow.board.web.dto.CustomExtensionDto;
import com.flow.board.web.entity.CustomExtension;
import com.flow.board.web.entity.FixedExtension;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final FixedExtensionRepository fixedExtensionRepository;
    private final CustomExtensionRepository customExtensionRepository;

    @GetMapping("/")
    public String index(Model model){
        List<FixedExtension> fixedExtensionList = fixedExtensionRepository.findAll();
        List<CustomExtension> customExtensionList = customExtensionRepository.findAll();
        model.addAttribute("fixedExtensionList", fixedExtensionList);
        model.addAttribute("customExtensionList", customExtensionList);
        model.addAttribute("customExtensionSize", customExtensionList.size());
        return "index";
    }

    @PostMapping("/custom")
    @ResponseBody
    public String createCustomExtension(@RequestBody CustomExtensionDto customExtensionDto){
        log.info("post mapping: {}", customExtensionDto.toString());
        customExtensionRepository.save(customExtensionDto.toEntity());
        return "추가 되었습니다";
    }

    @ResponseBody
    @DeleteMapping("/custom/{id}")
    @Transactional
    public String deleteCustomExtension(@PathVariable long id){
        customExtensionRepository.deleteById(id);
        return "삭제 되었습니다.";
    }


}
