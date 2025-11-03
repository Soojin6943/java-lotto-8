package lotto.model;

import java.util.List;

public class WinningLotto {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        List<Integer> userLottoNumbers = lotto.getNumbers();
        return (int) userLottoNumbers.stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
    }

    public boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
