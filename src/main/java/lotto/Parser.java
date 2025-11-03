package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }

    public List<Integer> parseWinningNumbers(String numbers) {
        try {
            List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 로또 번호 입니다.");
        }
    }
}
