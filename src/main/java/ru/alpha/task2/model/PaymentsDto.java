package ru.alpha.task2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentsDto {

    private String ref;
    private Long categoryId;
    private String userId;
    private String recipientId;
    private String desc;
    private Double amount;

//    {
//        "ref":"U030306190000188",
//            "categoryId":1,
//            "userId":"XAABAA",
//            "recipientId":"XA3SZV",
//            "desc":"Платеж за услуги",
//            "amount":10.0
//
//    }
}