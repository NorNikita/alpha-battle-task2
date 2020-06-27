package ru.alpha.task2.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.alpha.task2.model.PaymentsDto;

@Slf4j
@Service
public class KafkaConsumer {

    @SneakyThrows
    //@KafkaListener(topics = {"RAW_PAYMENTS"})
    public void getData(PaymentsDto paymentsDto) {
        log.info("CONSUMER GET MESSAGE: {}", new ObjectMapper().writeValueAsString(paymentsDto));
    }
}
