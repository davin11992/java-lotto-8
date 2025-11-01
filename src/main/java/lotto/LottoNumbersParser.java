package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersParser {
    private LottoNumbersParser() {
    }

    public static List<Integer> parse(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분해야 합니다.");
        }

        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해 주세요.");
        }
    }
}
