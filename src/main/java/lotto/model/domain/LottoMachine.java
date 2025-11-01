package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int PRICE = 1000;
    public static final int NUMBER_START = 1;
    public static final int NUMBER_END = 45;
    public static final int NUMBER_COUNT = 6;

    public List<Lotto> buy(int buyAmount) {
        int number = buyAmount / PRICE;
        return IntStream.range(0, number)
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .toList();
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(NUMBER_START, NUMBER_END, NUMBER_COUNT);
    }
}
