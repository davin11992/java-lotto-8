package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputLottoNumbersParserTest {

    @Test
    void 쉼표로_구분된_숫자문자열을_리스트로_변환한다() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = InputLottoNumbersParser.parse(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 숫자가_아닌_값이_포함되어_있으면_예외발생() {
        String input = "1,2,3,abc,5,6";
        assertThatThrownBy(() -> InputLottoNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자연수를 입력해 주세요.");
    }
}
