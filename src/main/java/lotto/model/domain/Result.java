package lotto.model.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public Result(List<Lotto> purchasedLottos, Lotto winningLotto) {
        for (Lotto lotto : purchasedLottos) {
            Rank rank = calculateRank(lotto, winningLotto);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank calculateRank(Lotto purchased, Lotto winning) {
        int matchCount = countMatch(purchased, winning);
        boolean bonusMatch = purchased.getNumbers().contains(winning.getBonusNumber());
        return Rank.of(matchCount, bonusMatch);
    }

    private int countMatch(Lotto purchased, Lotto winning) {
        return (int) purchased.getNumbers().stream()
                .filter(winning.getNumbers()::contains)
                .count();
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }
}
