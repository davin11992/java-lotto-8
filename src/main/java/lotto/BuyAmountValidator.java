package lotto;

public class BuyAmountValidator {
    private BuyAmountValidator() {
    }

    public static int validate(String inputBuyAmount) {
        if (inputBuyAmount.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어 있습니다.");
        }

        int buyAmount;
        try {
            buyAmount = Integer.parseInt(inputBuyAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해 주세요.");
        }

        if (buyAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해 주세요.");
        }

        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }

        return buyAmount;
    }
}
