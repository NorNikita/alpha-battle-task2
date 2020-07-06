package ru.alpha.task2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticPaymentDto {

    private String userId;
    private Double totalSum;
    private Map<String, AnalyticInfo> analyticInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AnalyticInfo {

        private Double min;
        private Double max;
        private Double sum;
    }
}
