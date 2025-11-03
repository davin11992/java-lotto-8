package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberValidatorTest {
    @Test
    void 양끝_공백은_허용_정수_변환() {
        int result = BonusNumberValidator.validate("  3 ");
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a3", "-3", "0", "3.5", "3 5", "3,5"})
    void 문자_음수_영_소수_2개_이상_숫자_예외(String input) {
        assertThatThrownBy(() -> BonusNumberValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BONUS_NUMBER);
    }
}
