package lotto.model;

import java.util.List;

public class WinningNumbers {
    private static final int LOTTO_COUNT = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;
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
        if (winningNumbers.stream().anyMatch(num -> num < MIN || num > MAX)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
