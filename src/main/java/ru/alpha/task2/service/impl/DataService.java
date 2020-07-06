package ru.alpha.task2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alpha.task2.model.entities.Payments;
import ru.alpha.task2.model.dto.PaymentDto;
import ru.alpha.task2.repository.PaymentsRepo;
import ru.alpha.task2.service.IDataService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DataService implements IDataService {

    private PaymentsRepo paymentsRepo;

    @Override
    public void savePaymentsDto(PaymentDto paymentDto) {
        Payments payment = Payments.builder()
                .ref(paymentDto.getRef())
                .categoryId(paymentDto.getCategoryId())
                .userId(paymentDto.getUserId())
                .recipientId(paymentDto.getRecipientId())
                .desc(paymentDto.getDesc())
                .amount(paymentDto.getAmount())
                .build();

        paymentsRepo.save(payment);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentsRepo.findAll()
                .stream()
                .map(payment ->
                        PaymentDto.builder()
                                .ref(payment.getRef())
                                .categoryId(payment.getCategoryId())
                                .userId(payment.getUserId())
                                .recipientId(payment.getRecipientId())
                                .desc(payment.getDesc())
                                .amount(payment.getAmount())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<List<PaymentDto>> getAllPaymentsByUserId(String userId) {
        return Optional.of(paymentsRepo.findAllByUserId(userId)
                .stream()
                .map(payment ->
                        PaymentDto.builder()
                                .ref(payment.getRef())
                                .categoryId(payment.getCategoryId())
                                .userId(payment.getUserId())
                                .recipientId(payment.getRecipientId())
                                .desc(payment.getDesc())
                                .amount(payment.getAmount())
                                .build())
                .collect(Collectors.toList()));
    }
}
