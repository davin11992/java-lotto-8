package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT);
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS);
        }
        boolean invalidRange = numbers.stream()
                .anyMatch(
                        number -> number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER);
        if (invalidRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
