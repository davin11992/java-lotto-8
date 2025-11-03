package lotto.util;

import lotto.common.ErrorMessage;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static int validate(String bonusNumber) {
        String trimmed = bonusNumber.trim();

        try {
            int number = Integer.parseInt(trimmed);
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER);
        }
    }
}
