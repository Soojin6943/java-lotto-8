package lotto;

public class Price {

    private final int UNIT = 1000;

    public int parseAmount(String amount) {
        try {
            return Integer.parseInt(amount.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
        }
    }

    public int toLottoCount(int amountPrice) {
        return amountPrice/UNIT;
    }
}
