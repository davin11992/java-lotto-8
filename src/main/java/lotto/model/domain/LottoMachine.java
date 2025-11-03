package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.LottoConstants;

public class LottoMachine {
    public List<Lotto> purchase(int purchaseAmount) {
        int number = purchaseAmount / LottoConstants.ONE_PRICE;
        return IntStream.range(0, number)
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .toList();
    }

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER,
                        LottoConstants.NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
