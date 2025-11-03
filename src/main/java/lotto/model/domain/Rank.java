package lotto.model.domain;

public enum Rank {
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    LOSS(0, false, 0, "");

    private final int matchCount;
    private final boolean requiresBonusNumber;
    private final int reward;
    private final String message;

    Rank(int matchCount, boolean requiresBonusNumber, int reward, String message) {
        this.matchCount = matchCount;
        this.requiresBonusNumber = requiresBonusNumber;
        this.reward = reward;
        this.message = message;
    }

    public static Rank of(int matchCount, boolean requiresBonusNumber) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && requiresBonusNumber) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return LOSS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
