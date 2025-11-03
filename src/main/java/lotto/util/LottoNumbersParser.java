package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.ErrorMessage;

public class LottoNumbersParser {
    public static final String DELIMITER = ",";
    public static final String ERROR_INVALID_DELIMITER_OR_LESS_THAN_6_NUMBERS = "[ERROR] 쉼표(,)로 6개의 숫자를 구분해야 합니다.";

    private LottoNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException(ERROR_INVALID_DELIMITER_OR_LESS_THAN_6_NUMBERS);
        }

        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }
    }
}
