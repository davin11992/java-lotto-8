package lotto.common;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static final String INVALID_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBERS = "[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다.";
    public static final String INVALID_RANGE = "[ERROR] 1부터 45 사이의 숫자를 입력해주세요.";
    public static final String DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String NOT_A_NATURAL_NUMBER = "[ERROR] 자연수를 입력해 주세요.";
    public static final String INVALID_DELIMITER_OR_LESS_THAN_6_NUMBERS = "[ERROR] 쉼표(,)로 6개의 숫자를 구분해야 합니다.";
    public static final String INVALID_PURCHASE_UNIT = "[ERROR] 구입 금액은 1000의 배수여야 합니다.";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 1개의 자연수를 입력해 주세요.";
}
