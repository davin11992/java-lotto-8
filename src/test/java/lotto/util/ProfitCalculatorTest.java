package lotto.util;

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
}
