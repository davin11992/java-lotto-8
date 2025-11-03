package lotto.common;

public class ErrorMessage {
    private ErrorMessage() {
    }
    
    public static final String INVALID_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBERS = "[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다.";
    public static final String INVALID_RANGE = "[ERROR] 1부터 45 사이의 숫자를 입력해주세요.";
    public static final String DUPLICATE_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String NOT_A_NATURAL_NUMBER = "[ERROR] 자연수를 입력해 주세요.";
}
