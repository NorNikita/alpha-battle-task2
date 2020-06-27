package ru.alpha.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alpha.task2.model.PaymentsDto;
import ru.alpha.task2.service.IDataService;

@RestController
@AllArgsConstructor
public class Controller {

    private IDataService dataService;

    @PostMapping("/create")
    @ResponseBody
    public PaymentsDto postDto(@RequestBody PaymentsDto paymentsDto) {
        dataService.savePaymentsDto(paymentsDto);
        return paymentsDto;
    }
}
