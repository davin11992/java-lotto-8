package lotto.util;

import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class PurchaseAmountValidator {

    public static final String ERROR_INVALID_PURCHASE_UNIT = "[ERROR] 구입 금액은 1000의 배수여야 합니다.";

    private PurchaseAmountValidator() {
    }

    public static int validate(String inputPurchaseAmount) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }

        if (purchaseAmount % LottoConstants.ONE_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_UNIT);
        }

        return purchaseAmount;
    }
}
