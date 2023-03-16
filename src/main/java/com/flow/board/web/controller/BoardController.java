package com.flow.board.web.controller;

import com.flow.board.service.CustomExtensionService;
import com.flow.board.service.FixedExtensionService;
import com.flow.board.web.dto.CustomExtensionDto;
import com.flow.board.web.dto.FixedExtensionDto;
import com.flow.board.entity.CustomExtension;
import com.flow.board.entity.FixedExtension;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final FixedExtensionService fixedExtensionService;
    private final CustomExtensionService customExtensionService;

    @GetMapping("/")
    public String index(Model model){
        List<FixedExtension> fixedExtensionList = fixedExtensionService.readAll();
        List<CustomExtension> customExtensionList = customExtensionService.readAll();
        model.addAttribute("fixedExtensionList", fixedExtensionList);
        model.addAttribute("customExtensionList", customExtensionList);
        model.addAttribute("customExtensionSize", customExtensionList.size());
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
    @DeleteMapping("/custom/{id}")
    public String deleteCustomExtension(@PathVariable long id){
        return customExtensionService.deleteCustomExtension(id);
    }



}
