package lotto.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또 개수가 결정된다.")
    @Test
    void 구입금액에_따라_로또_개수가_결정된다() {
        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos = machine.buy(7000);
        assertThat(lottos).hasSize(7);
    }

    @DisplayName("랜덤번호 6개가 중복없이 생성된다.")
    @Test
    void 랜덤번호_6개가_중복없이_생성된다() {
        LottoMachine machine = new LottoMachine();
        List<Integer> numbers = machine.generateRandomNumbers();

        assertThat(numbers).hasSize(6);
        assertThat(numbers).doesNotHaveDuplicates();
        assertThat(numbers).allMatch(n -> n >= 1 && n <= 45);
    }

    @DisplayName("구매금액에 따른 개수만큼 로또가 각각 랜덤번호 6개 중복없이 생성된다")
    @Test
    void 구매금액에_따른_개수만큼_로또가_각각_랜덤번호_6개_중복없이_생성된다() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            LottoMachine lottoMachine = new LottoMachine();
            List<Lotto> lottos = lottoMachine.buy(2000);
            assertThat(lottos).hasSize(2);
            assertThat(lottos.get(0).getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
            assertThat(lottos.get(1).getNumbers()).containsExactly(3, 5, 11, 16, 32, 38);
        }, List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 11, 16, 32, 38));
    }
}
