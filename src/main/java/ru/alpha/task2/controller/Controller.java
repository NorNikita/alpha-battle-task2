package ru.alpha.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alpha.task2.model.dto.HealthDto;
import ru.alpha.task2.model.dto.StatisticPaymentDto;
import ru.alpha.task2.service.IAgregationService;
import ru.alpha.task2.service.IDataService;

import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {

    private IDataService dataService;
    private IAgregationService agregationService;

    @GetMapping("/admin/health")
    public ResponseEntity<HealthDto> health() {
        return ResponseEntity.ok(HealthDto.builder().status("UP").build());
    }

    @GetMapping("/analytic")
    @ResponseBody
    public List<StatisticPaymentDto> get() {
        return agregationService.getAnaliticByUserId();
    }
}
