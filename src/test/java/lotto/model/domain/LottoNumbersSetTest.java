package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersSetTest {
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 5;

        assertThatThrownBy(() -> new LottoNumbersSet(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 70})
    void 보너스_번호가_1부터_45_사이의_숫자가_아니면_예외(int bonusNumber) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new LottoNumbersSet(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_RANGE);
    }
}
