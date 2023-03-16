package com.flow.file.web.controller;

import com.flow.file.biz.service.CustomExtensionService;
import com.flow.file.biz.service.FixedExtensionService;
import com.flow.file.web.dto.CustomExtensionDto;
import com.flow.file.web.dto.FixedExtensionDto;
import com.flow.file.biz.entity.CustomExtension;
import com.flow.file.biz.entity.FixedExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FixedExtensionService fixedExtensionService;
    private final CustomExtensionService customExtensionService;

    @GetMapping("/")
    public String index(Model model){
        List<FixedExtension> fixedExtensionList = fixedExtensionService.readAll();
        List<CustomExtension> customExtensionList = customExtensionService.readAll();
        model.addAttribute("fixedExtensionList", fixedExtensionList);
        model.addAttribute("customExtensionList", customExtensionList);
        model.addAttribute("customExtensionListSize", customExtensionList.size());
        model.addAttribute("customExtensionMaxSize", CustomExtension.MAX_SIZE);
        return "index";
    }

    @ResponseBody
    @PutMapping("/fixed")
    public String updateFixedExtension(@RequestBody FixedExtensionDto fixedExtensionDto){
        return fixedExtensionService.updateFixedExtension(fixedExtensionDto);
    }

    @ResponseBody
    @PostMapping("/custom")
    public String createCustomExtension(@RequestBody CustomExtensionDto customExtensionDto){
        return customExtensionService.createCustomExtension(customExtensionDto);
    }

    @ResponseBody
    @DeleteMapping("/custom")
    public String deleteCustomExtension(@RequestBody CustomExtensionDto customExtensionDto){
        return customExtensionService.deleteCustomExtension(customExtensionDto);
    }



}
