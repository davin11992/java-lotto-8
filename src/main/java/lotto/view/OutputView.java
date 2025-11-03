package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;

public class OutputView {
    public void printPurchasedLottos(List<Lotto> purchaseLottos) {
        System.out.println();
        System.out.println(purchaseLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchaseLottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> rankCounts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            if (rank == Rank.LOSS) {
                continue;
            }
            System.out.println(rank.getMessage() + " - "
                    + rankCounts.getOrDefault(rank, 0) + "개");
        }
    }

    public void printProfit(BigDecimal profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
