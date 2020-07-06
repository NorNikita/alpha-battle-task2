package ru.alpha.task2.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.alpha.task2.model.dto.PaymentDto;
import ru.alpha.task2.service.IDataService;

import java.io.IOException;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {

    private IDataService dataService;
    private ObjectMapper objectMapper;

    @KafkaListener(topics = {"RAW_PAYMENTS"}, groupId = "1")
    public void getData(PaymentDto paymentDto) throws IOException {

        dataService.savePaymentsDto(paymentDto);

        log.info("dto successful saved {}", objectMapper.writeValueAsString(paymentDto));
    }
}
