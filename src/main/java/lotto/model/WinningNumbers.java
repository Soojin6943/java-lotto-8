package lotto.model;

import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_COUNT = 6;
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 존재합니다.");
        }
    }
}
