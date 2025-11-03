package lotto.util;

public class BonusNumberValidator {
    private BonusNumberValidator() {
    }

    public static int validate(String bonusNumber) {
        String trimmed = bonusNumber.trim();

        try {
            int number = Integer.parseInt(trimmed);

            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 1개의 자연수를 입력해 주세요.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 1개의 자연수를 입력해 주세요.");
        }
    }
}
