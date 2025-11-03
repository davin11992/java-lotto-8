package lotto.util;

import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
    }

    public static int validate(String inputPurchaseAmount) {
        int purchaseAmount = parseToInt(inputPurchaseAmount);
        validateNaturalNumber(purchaseAmount);
        validateUnit(purchaseAmount);
        return purchaseAmount;
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }
    }

    private static void validateNaturalNumber(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }
    }

    private static void validateUnit(int amount) {
        if (amount % LottoConstants.ONE_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT);
        }
    }
}
