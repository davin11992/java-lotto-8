package lotto.model.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = -1;
    }

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validateBonusNumber(bonusNumber, numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자여야 합니다.");
        }
        boolean invalidRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45);
        if (invalidRange) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해주세요.");
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해주세요.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
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
