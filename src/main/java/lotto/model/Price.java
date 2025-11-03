package lotto.model;

public class Price {

    private static final int UNIT = 1000;
    private final int value;

    public Price(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원보다 작을 수 없습니다.");
        }
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액은 1,000단위입니다.");
        }
    }

    public int toLottoCount() {
        return value / UNIT;
    }

    public int getValue() {
        return this.value;
    }
}
