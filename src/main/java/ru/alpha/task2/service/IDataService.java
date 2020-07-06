package ru.alpha.task2.service;

import ru.alpha.task2.model.dto.PaymentDto;

import java.util.List;
import java.util.Optional;

public interface IDataService {

    void savePaymentsDto(PaymentDto paymentsDto);

    List<PaymentDto> getAllPayments();

    Optional<List<PaymentDto>> getAllPaymentsByUserId(String userId);
}
