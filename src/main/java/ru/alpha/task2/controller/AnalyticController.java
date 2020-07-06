package ru.alpha.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alpha.task2.model.dto.StatUserDto;
import ru.alpha.task2.model.dto.StatusDto;
import ru.alpha.task2.model.dto.StatisticPaymentDto;
import ru.alpha.task2.service.IAgregationService;

import java.util.List;

@RestController
@RequestMapping("/analytic")
@AllArgsConstructor
public class AnalyticController {

    private IAgregationService agregationService;

    @GetMapping("/admin/health")
    public ResponseEntity<StatusDto> health() {
        return ResponseEntity.ok(StatusDto.builder().status("UP").build());
    }

    @GetMapping
    @ResponseBody
    public List<StatisticPaymentDto> getAllAnalytic() {
        return agregationService.getAllAnalytics();
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public StatisticPaymentDto getUserAnalytic(@PathVariable String userId) {
        return agregationService.getAnalyticByUserId(userId);
    }

    @GetMapping("/{userId}/stat")
    @ResponseBody
    public StatUserDto statUser(@PathVariable String userId) {
        return agregationService.getStat(userId);
    }
}
