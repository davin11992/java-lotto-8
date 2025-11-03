package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    void 모든_등수_당첨과_낙첨_테스트() {
        // given
        LottoNumbersSet lottoNumbersSet = new LottoNumbersSet(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                new Lotto(List.of(1, 9, 10, 11, 12, 13))
        );

        // when
        Result result = new Result(purchasedLottos, lottoNumbersSet);
        Map<Rank, Integer> rankCounts = result.getRankCounts();

        // then
        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.LOSS)).isEqualTo(1);
    }

    @Test
    void 이등_두번인_경우() {
        // given
        LottoNumbersSet lottoNumbersSet = new LottoNumbersSet(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 6, 7))
        );

        // when
        Result result = new Result(purchasedLottos, lottoNumbersSet);
        Map<Rank, Integer> rankCounts = result.getRankCounts();

        // then
        assertThat(rankCounts.getOrDefault(Rank.FIRST, 0)).isEqualTo(0);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(2);
        assertThat(rankCounts.getOrDefault(Rank.THIRD, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.FOURTH, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.FIFTH, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.LOSS, 0)).isEqualTo(0);
    }


    @Test
    void 전부_낙첨인_경우() {
        LottoNumbersSet lottoNumbersSet = new LottoNumbersSet(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(20, 21, 22, 23, 24, 25))
        );

        Result result = new Result(purchasedLottos, lottoNumbersSet);
        Map<Rank, Integer> rankCounts = result.getRankCounts();

        assertThat(rankCounts.getOrDefault(Rank.LOSS, 0)).isEqualTo(2);
        assertThat(rankCounts.getOrDefault(Rank.FIRST, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.SECOND, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.THIRD, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.FOURTH, 0)).isEqualTo(0);
        assertThat(rankCounts.getOrDefault(Rank.FIFTH, 0)).isEqualTo(0);
    }
}
