package lotto.model.domain;

import java.util.List;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class LottoNumbersSet {
    private final Lotto lotto;
    private final int bonusNumber;

    public LottoNumbersSet(Lotto lotto, int bonusNumber) {
        validateBonusNumber(bonusNumber, lotto.getNumbers());
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (bonusNumber < LottoConstants.MIN_NUMBER || bonusNumber > LottoConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
