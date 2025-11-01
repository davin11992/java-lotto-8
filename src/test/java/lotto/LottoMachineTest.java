package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @DisplayName("구입 금액에 따라 로또 개수가 결정된다.")
    @Test
    void 구입금액에_따라_로또_개수가_결정된다() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buy(7000);
        assertThat(lottos).hasSize(7);
    }
}
