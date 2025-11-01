package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    public static final int PRICE = 1000;

    public List<Lotto> buy(int buyAmount) {
        int number = buyAmount / PRICE;
        return IntStream.range(0, number)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }
}
