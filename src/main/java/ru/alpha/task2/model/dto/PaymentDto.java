package ru.alpha.task2.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {

    private String ref;
    private Long categoryId;
    private String userId;
    private String recipientId;
    private String desc;
    private Double amount;

}