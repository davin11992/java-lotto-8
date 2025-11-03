package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumbersParserTest {

    @Test
    void 쉼표로_구분된_숫자문자열을_리스트로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = LottoNumbersParser.parse(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,abc,5,6", "1,2,3,3.5,5,6",
            "1, ,3,4,5,6", "1,a,3,4,5,6"
    })
    void 자연수가_아닌_값이_포함되어_있으면_예외(String input) {
        assertThatThrownBy(() -> LottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자연수를 입력해 주세요.");
    }

    @Test
    void 쉼표로_구분하지_않으면_예외() {
        String input = "2/3/4/5/6/7";
        assertThatThrownBy(() -> LottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 쉼표(,)로 6개의 숫자를 구분해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a3", "-3", "0", "3.5", "3 5", "1"})
    void 문자_음수_영_소수_사이_공백_숫자_예외(String input) {
        assertThatThrownBy(() -> LottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 쉼표(,)로 6개의 숫자를 구분해야 합니다.");
    }
}
