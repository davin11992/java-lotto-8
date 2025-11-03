package lotto.model.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.model.domain.Rank;

public class ProfitCalculator {
    public static final int DIVIDE_SCALE = 6;
    public static final int PERCENTAGE_MULTIPLIER = 100;
    public static final int DISPLAY_SCALE = 1;

    private ProfitCalculator() {
    }

    public static BigDecimal calculateTotalProfitRate(Map<Rank, Integer> rankCounts, int purchaseAmount) {
        long totalPrizeAmount = sumTotalPrize(rankCounts);
        return calculateProfitRate(totalPrizeAmount, purchaseAmount);
    }

    public static long sumTotalPrize(Map<Rank, Integer> rankCounts) {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    public static BigDecimal calculateProfitRate(long totalPrizeAmount, int purchaseAmount) {
        BigDecimal totalPrize = BigDecimal.valueOf(totalPrizeAmount);
        BigDecimal purchase = BigDecimal.valueOf(purchaseAmount);

        return totalPrize.divide(purchase, DIVIDE_SCALE, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(PERCENTAGE_MULTIPLIER))
                .setScale(DISPLAY_SCALE, RoundingMode.HALF_UP);
    }
}
