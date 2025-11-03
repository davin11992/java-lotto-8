package lotto.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.common.LottoConstants;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @Test
    void 구입금액에_따라_로또_개수가_결정된다() {
        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos = machine.purchase(7000);
        assertThat(lottos).hasSize(7);
    }

    @Test
    void 랜덤번호_6개가_중복없이_생성된다() {
        LottoMachine machine = new LottoMachine();
        List<Integer> numbers = machine.generateRandomNumbers();

        assertThat(numbers).hasSize(LottoConstants.NUMBER_COUNT);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(n -> n >= LottoConstants.MIN_NUMBER && n <= LottoConstants.MAX_NUMBER);
    }

    @Test
    void 구매금액에_따른_개수만큼_로또가_각각_랜덤번호_6개_중복없이_생성된다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoMachine lottoMachine = new LottoMachine();
            List<Lotto> lottos = lottoMachine.purchase(2000);
            assertThat(lottos).hasSize(2);
            assertThat(lottos.get(0).getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
            assertThat(lottos.get(1).getNumbers()).containsExactly(3, 5, 11, 16, 32, 38);
        }, List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38));
    }
}
