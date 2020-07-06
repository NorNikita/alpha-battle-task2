package ru.alpha.task2.service;

import ru.alpha.task2.model.dto.StatisticPaymentDto;

import java.util.List;

public interface IAgregationService {

    List<StatisticPaymentDto> getAnaliticByUserId();
}
