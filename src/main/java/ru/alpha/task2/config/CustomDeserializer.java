package ru.alpha.task2.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.alpha.task2.model.dto.PaymentDto;

@Slf4j
public class CustomDeserializer extends JsonDeserializer<PaymentDto> {

    @Override
    public PaymentDto deserialize(String topic, Headers headers, byte[] data) {
        try {
            return super.deserialize(topic, headers, data);

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }
}
