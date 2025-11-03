package lotto.util;

public class BonusNumberValidator {

    public static final String INVALID_BONUS_NUMBER = "[ERROR] 1개의 자연수를 입력해 주세요.";

    private BonusNumberValidator() {
    }

    public static int validate(String bonusNumber) {
        String trimmed = bonusNumber.trim();

        try {
            int number = Integer.parseInt(trimmed);
            if (number <= 0) {
                throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }
}
