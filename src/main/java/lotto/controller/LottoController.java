package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoNumbersSet;
import lotto.model.domain.Rank;
import lotto.model.domain.Result;
import lotto.model.service.ProfitCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmount();

        List<Lotto> purchasedLottos = lottoMachine.purchase(purchaseAmount);
        outputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = readWinningNumbers();

        int bonusNumber = readBonusNumber(winningNumbers);

        Lotto lotto = new Lotto(winningNumbers);
        LottoNumbersSet lottoNumbersSet = new LottoNumbersSet(lotto, bonusNumber);

        Result result = new Result(purchasedLottos, lottoNumbersSet);
        Map<Rank, Integer> rankCounts = result.getRankCounts();
        outputView.printResult(rankCounts);

        BigDecimal profit = ProfitCalculator.calculateTotalProfitRate(rankCounts, purchaseAmount);
        outputView.printProfit(profit);
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                new LottoNumbersSet(new Lotto(winningNumbers), bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
