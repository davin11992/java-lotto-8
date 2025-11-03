package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class Lotto {
    public static final int NO_BONUS_NUMBER = -1;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = NO_BONUS_NUMBER;
    }

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
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

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < LottoConstants.MIN_NUMBER || bonusNumber > LottoConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
