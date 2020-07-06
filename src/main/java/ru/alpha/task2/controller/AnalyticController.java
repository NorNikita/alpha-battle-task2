package ru.alpha.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alpha.task2.model.dto.HealthDto;
import ru.alpha.task2.model.dto.StatisticPaymentDto;
import ru.alpha.task2.service.IAgregationService;

import java.util.List;

@RestController
@RequestMapping("/analytic")
@AllArgsConstructor
public class AnalyticController {

    private IAgregationService agregationService;

    @GetMapping("/admin/health")
    public ResponseEntity<HealthDto> health() {
        return ResponseEntity.ok(HealthDto.builder().status("UP").build());
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
}
