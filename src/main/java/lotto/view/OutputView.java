package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;

public class OutputView {
    public static final String MESSAGE_PURCHASE_COUNT_SUFFIX = "개를 구매했습니다.";
    public static final String MESSAGE_RESULT_TITLE = "당첨 통계";
    public static final String MESSAGE_RESULT_SEPARATOR = "---";
    public static final String MESSAGE_PROFIT_PREFIX = "총 수익률은 ";
    public static final String MESSAGE_PROFIT_SUFFIX = "%입니다.";

    public static final String FORMAT_SEPARATOR = " - ";
    public static final String UNIT_COUNT = "개";

    public void printPurchasedLottos(List<Lotto> purchaseLottos) {
        System.out.println();
        System.out.println(purchaseLottos.size() + MESSAGE_PURCHASE_COUNT_SUFFIX);
        for (Lotto lotto : purchaseLottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> rankCounts) {
        System.out.println();
        System.out.println(MESSAGE_RESULT_TITLE);
        System.out.println(MESSAGE_RESULT_SEPARATOR);

        for (Rank rank : Rank.values()) {
            if (rank == Rank.LOSS) {
                continue;
            }
            System.out.println(rank.getMessage() + FORMAT_SEPARATOR
                    + rankCounts.getOrDefault(rank, 0) + UNIT_COUNT);
        }
    }

    public void printProfit(BigDecimal profit) {
        System.out.println(MESSAGE_PROFIT_PREFIX + profit + MESSAGE_PROFIT_SUFFIX);
    }
}
