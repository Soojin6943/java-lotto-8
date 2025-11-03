package lotto.model;

import java.util.List;

public class BonusNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final int bonusNumber;

    public BonusNumber(int bonus, WinningNumbers winning) {
        validate(bonus, winning);
        this.bonusNumber = bonus;

    }

    private void validate(int bonus, WinningNumbers winning) {
        if (winning.getWinningNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 보너스 번호는 불가능합니다.");
        }
        if (bonus < MIN || bonus > MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
