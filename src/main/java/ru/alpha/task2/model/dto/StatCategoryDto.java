package ru.alpha.task2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatCategoryDto implements BiConsumer<StatCategoryDto, PaymentDto> {

    private Map<Long, Long> idToCount = new HashMap<>();
    private Map<Long, MaxMin> idToMaxMin = new HashMap<>();

    public void accumulate(PaymentDto paymentDto) {
        Long categoryId = paymentDto.getCategoryId();
        Double amount = paymentDto.getAmount();

        Long newCount = idToCount.get(categoryId) == null ? 1 : idToCount.get(categoryId)+1;

        MaxMin maxMin;
        if(idToMaxMin.get(categoryId) != null) {
            maxMin = idToMaxMin.get(categoryId);
            maxMin.max = amount > maxMin.max ? amount : maxMin.max;
            maxMin.min = amount < maxMin.min ? amount : maxMin.min;
        } else {
            maxMin = new MaxMin(amount, amount);
        }

        idToCount.put(categoryId, newCount);
        idToMaxMin.put(categoryId, maxMin);
    }

    @Override
    public void accept(StatCategoryDto statCategoryDto, PaymentDto paymentDto) {
        Map<Long, Long> idToCount = statCategoryDto.getIdToCount();
        Map<Long, MaxMin> idToMaxMin = statCategoryDto.getIdToMaxMin();

        Long categoryId = paymentDto.getCategoryId();
        Double amount = paymentDto.getAmount();

        Long count = idToCount.get(categoryId);
        MaxMin maxMin = idToMaxMin.get(categoryId);

        if(count != null) {
            idToCount.put(categoryId, ++count);

            maxMin.max = amount > maxMin.max ? amount : maxMin.max;
            maxMin.min = amount < maxMin.min ? amount : maxMin.min;

            idToMaxMin.put(categoryId, maxMin);

        } else {
            idToCount.put(categoryId, 1L);
            idToMaxMin.put(categoryId, new MaxMin(amount, amount));
        }
    }

    public static void combine(StatCategoryDto statCategoryDto1, StatCategoryDto statCategoryDto2) {
        Map<Long, Long> idToCount2 = statCategoryDto2.getIdToCount();

        statCategoryDto1.getIdToCount().forEach((key, value) -> {
            idToCount2.merge(key, value, (v1, v2) -> v1 + v2);
        });
        statCategoryDto1.setIdToCount(idToCount2);


        Map<Long, MaxMin> idToMaxMin2 = statCategoryDto2.getIdToMaxMin();

        statCategoryDto1.getIdToMaxMin().forEach((key, value) -> idToMaxMin2
                .merge(key, value, (v1, v2) -> {
                            double max = v1.getMax() > v2.getMax() ? v1.getMax() : v2.getMax();
                            double min = v1.getMin() > v2.getMin() ? v2.getMin() : v1.getMin();
                            return new MaxMin(min, max);
                })
        );
        statCategoryDto1.setIdToMaxMin(idToMaxMin2);
    }

    public String getOftenCategoryId() {
        Map.Entry<Long, Long> longLongEntry = idToCount.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        return longLongEntry.getKey().toString();
    }

    public String getRareCategoryId() {
        Map.Entry<Long, Long> min = idToCount.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue)).get();
        return min.getKey().toString();
    }

    public String getMaxAmountCategoryId() {
        Map.Entry<Long, MaxMin> maxCategory = idToMaxMin.entrySet().stream().max(Comparator.comparing(entry -> entry.getValue().getMax())).get();
        return maxCategory.getKey().toString();
    }

    public String getMinAmountCategoryId() {
        Map.Entry<Long, MaxMin> maxCategory = idToMaxMin.entrySet().stream().min(Comparator.comparing(entry -> entry.getValue().getMin())).get();
        return maxCategory.getKey().toString();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static class MaxMin {
        double min;
        double max;
    }
}