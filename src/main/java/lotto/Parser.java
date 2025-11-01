package lotto;

public class Parser {
    public int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }
}
