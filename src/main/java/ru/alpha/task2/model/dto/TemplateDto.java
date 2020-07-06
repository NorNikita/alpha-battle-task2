package ru.alpha.task2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemplateDto {

    private String recipientId;
    private String categoryId;
    private Double amount;
}
