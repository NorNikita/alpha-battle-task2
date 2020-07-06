package ru.alpha.task2.service;

import ru.alpha.task2.model.dto.PaymentDto;

import java.util.List;

public interface IDataService {

    void savePaymentsDto(PaymentDto paymentsDto);

    List<PaymentDto> getAllPayments();

    List<PaymentDto> getAllPaymentsByUserId(String userId);
}
