package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import lotto.model.domain.Rank;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    @Test
    void 모든_등수_당첨과_낙첨_수익률() {
        // given
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.FIRST, 1);
        rankCounts.put(Rank.SECOND, 1);
        rankCounts.put(Rank.THIRD, 1);
        rankCounts.put(Rank.FOURTH, 1);
        rankCounts.put(Rank.FIFTH, 1);
        rankCounts.put(Rank.LOSS, 1);

        int purchaseAmount = 6_000;

        // when
        BigDecimal profitRate = ProfitCalculator.calculate(rankCounts, purchaseAmount);

        // then
        // (2,000,000,000 + 30,000,000 + 1,500,000 + 50,000 + 5,000) / 6,000 * 100
        // = 33,859,250%
        assertThat(profitRate).isEqualByComparingTo("33859250.0");
    }

    @Test
    void 낙첨만_3번() {
        // given
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.LOSS, 3);
        int purchaseAmount = 3_000;

        // when
        BigDecimal profitRate = ProfitCalculator.calculate(rankCounts, purchaseAmount);

        // then
        assertThat(profitRate).isEqualByComparingTo("0.0");
    }

    @Test
    void calculateTotalPrize_정상작동() {
        // given
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.FIRST, 1);
        rankCounts.put(Rank.SECOND, 2);
        rankCounts.put(Rank.THIRD, 3);
        rankCounts.put(Rank.FOURTH, 4);
        rankCounts.put(Rank.FIFTH, 5);
        rankCounts.put(Rank.LOSS, 6);

        // when
        long totalPrize = ProfitCalculator.calculateTotalPrize(rankCounts);

        // then
        long expectedResult = 2_000_000_000L + 60_000_000L + 4_500_000L + 200_000L + 25_000L;
        assertThat(totalPrize).isEqualTo(expectedResult);
    }

    @Test
    void calculateProfitRate_정상작동() {
        // given
        long totalPrizeAmount = 10_000L;
        int purchaseAmount = 5_000;

        // when
        BigDecimal profitRate = ProfitCalculator.calculateProfitRate(totalPrizeAmount, purchaseAmount);

        // then
        assertThat(profitRate).isEqualByComparingTo("200.0");
    }

    @Test
    void calculateProfitRate_반올림_테스트() {
        // given
        long totalPrizeAmount = 1000L;
        int purchaseAmount = 3;

        // when
        BigDecimal profitRate = ProfitCalculator.calculateProfitRate(totalPrizeAmount, purchaseAmount);

        // then
        assertThat(profitRate).isEqualByComparingTo("33333.3");
        assertThat(profitRate.scale()).isEqualTo(1);
    }
}
