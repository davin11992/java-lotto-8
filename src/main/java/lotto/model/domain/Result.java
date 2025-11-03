package lotto.model.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public Result(List<Lotto> purchasedLottos, LottoNumbersSet lottoNumbersSet) {
        for (Lotto lotto : purchasedLottos) {
            Rank rank = calculateRank(lotto, lottoNumbersSet);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank calculateRank(Lotto purchasedLotto, LottoNumbersSet lottoNumbersSet) {
        int matchCount = countMatch(purchasedLotto, lottoNumbersSet.getLotto());
        boolean bonusMatch = purchasedLotto.getNumbers().contains(lottoNumbersSet.getBonusNumber());
        return Rank.of(matchCount, bonusMatch);
    }

    private int countMatch(Lotto purchasedLotto, Lotto winningLotto) {
        return (int) purchasedLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}
