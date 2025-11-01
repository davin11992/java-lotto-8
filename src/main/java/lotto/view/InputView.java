package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputBuyAmountValidator;

public class InputView {
    public int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputBuyAmount = Console.readLine();

        return InputBuyAmountValidator.validate(inputBuyAmount);
    }
}
