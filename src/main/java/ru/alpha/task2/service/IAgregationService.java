package ru.alpha.task2.service;

import ru.alpha.task2.model.dto.StatUserDto;
import ru.alpha.task2.model.dto.StatisticPaymentDto;
import ru.alpha.task2.model.dto.TemplateDto;

import java.util.List;

public interface IAgregationService {

    List<StatisticPaymentDto> getAllAnalytics();

    StatisticPaymentDto getAnalyticByUserId(String userId);

    StatUserDto getStat(String userId);

    List<TemplateDto> getTemplatePayments(String userId);
}
