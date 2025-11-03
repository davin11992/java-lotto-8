package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.common.ErrorMessage;

public class LottoNumbersParser {
    public static final String DELIMITER = ",";

    private LottoNumbersParser() {
    }

    public static List<Integer> parse(String winningNumbers) {
        validateDelimiter(winningNumbers);
        return convertToIntegers(winningNumbers);
    }

    private static void validateDelimiter(String winningNumbers) {
        if (!winningNumbers.contains(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER_OR_LESS_THAN_6_NUMBERS);
        }
    }

    private static List<Integer> convertToIntegers(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NATURAL_NUMBER);
        }
    }
}
