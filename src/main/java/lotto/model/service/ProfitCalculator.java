package lotto.model.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.model.domain.Rank;

public class ProfitCalculator {
    private ProfitCalculator() {
    }

    public static BigDecimal calculate(Map<Rank, Integer> rankCounts, int purchaseAmount) {
        long totalPrizeAmount = calculateTotalPrize(rankCounts);
        return calculateProfitRate(totalPrizeAmount, purchaseAmount);
    }

    public static long calculateTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public static BigDecimal calculateProfitRate(long totalPrizeAmount, int purchaseAmount) {
        BigDecimal totalPrize = BigDecimal.valueOf(totalPrizeAmount);
        BigDecimal purchase = BigDecimal.valueOf(purchaseAmount);

        return totalPrize.divide(purchase, 6, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);
    }
}
