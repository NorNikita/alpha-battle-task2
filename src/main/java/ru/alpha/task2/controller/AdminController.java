package ru.alpha.task2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alpha.task2.model.dto.StatusDto;

@RestController
@RequestMapping("/admin/health")
public class AdminController {

    @GetMapping
    @ResponseBody
    public StatusDto health() {
        return StatusDto.builder()
                .status("UP")
                .build();
    }
}
