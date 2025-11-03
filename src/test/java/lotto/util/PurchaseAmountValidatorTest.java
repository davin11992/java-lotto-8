package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PurchaseAmountValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "-1000", "0", "3.1"})
    void 자연수가_아니면_예외가_발생한다(String inputBuyAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(inputBuyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자연수를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"500", "1500"})
    void 천의_배수가_아니면_예외가_발생한다(String inputBuyAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(inputBuyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000의 배수여야 합니다.");
    }
}
