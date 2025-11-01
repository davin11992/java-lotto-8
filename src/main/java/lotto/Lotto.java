package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
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

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
