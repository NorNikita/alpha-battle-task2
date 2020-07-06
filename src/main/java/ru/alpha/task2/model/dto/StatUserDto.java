package ru.alpha.task2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatUserDto {

    private String oftenCategoryId;
    private String rareCategoryId;
    private String maxAmountCategoryId;
    private String minAmountCategoryId;
}
