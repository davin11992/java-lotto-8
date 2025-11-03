package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.BonusNumberValidator;
import lotto.util.LottoNumbersParser;
import lotto.util.PurchaseAmountValidator;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        return PurchaseAmountValidator.validate(checkBlank(inputPurchaseAmount));
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        return LottoNumbersParser.parse(checkBlank(inputWinningNumbers));
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        return BonusNumberValidator.validate(checkBlank(inputBonusNumber));
    }

    private String checkBlank(String input) {
        if (input.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }
        return input;
    }
}
