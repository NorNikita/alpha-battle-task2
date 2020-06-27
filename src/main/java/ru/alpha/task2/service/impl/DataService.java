package ru.alpha.task2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alpha.task2.model.Payments;
import ru.alpha.task2.model.PaymentsDto;
import ru.alpha.task2.repository.PaymentsRepo;
import ru.alpha.task2.service.IDataService;

@Service
@AllArgsConstructor
public class DataService implements IDataService {

    private PaymentsRepo paymentsRepo;

    @Override
    public void savePaymentsDto(PaymentsDto paymentsDto) {
        Payments payment = Payments.builder()
                .ref(paymentsDto.getRef())
                .categoryId(paymentsDto.getCategoryId())
                .userId(paymentsDto.getUserId())
                .recipientId(paymentsDto.getRecipientId())
                .desc(paymentsDto.getDesc())
                .amount(paymentsDto.getAmount())
                .build();

        paymentsRepo.save(payment);
    }
}
