package lotto.util;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
    }

    public static int validate(String inputPurchaseAmount) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해 주세요.");
        }

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해 주세요.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
        }

        return purchaseAmount;
    }
}
