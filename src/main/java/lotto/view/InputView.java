package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.BonusNumberValidator;
import lotto.util.LottoNumbersParser;
import lotto.util.PurchaseAmountValidator;

public class InputView {
    public static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String MESSAGE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String ERROR_EMPTY_INPUT = "[ERROR] 입력값이 비어 있습니다.";

    public int inputPurchaseAmount() {
        System.out.println(MESSAGE_INPUT_PURCHASE_AMOUNT);
        String inputPurchaseAmount = Console.readLine();
        return PurchaseAmountValidator.validate(checkBlank(inputPurchaseAmount));
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(MESSAGE_INPUT_WINNING_NUMBERS);
        String inputWinningNumbers = Console.readLine();
        return LottoNumbersParser.parse(checkBlank(inputWinningNumbers));
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        String inputBonusNumber = Console.readLine();
        return BonusNumberValidator.validate(checkBlank(inputBonusNumber));
    }

    private String checkBlank(String input) {
        if (input.trim().isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
        return input;
    }
}
