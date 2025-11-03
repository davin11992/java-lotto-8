package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PurchaseAmountValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "-1000", "0", "3.1"})
    void 자연수가_아니면_예외가_발생한다(String inputBuyAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(inputBuyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_A_NATURAL_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"500", "1500"})
    void 천의_배수가_아니면_예외가_발생한다(String inputBuyAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(inputBuyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_UNIT);
    }
}
