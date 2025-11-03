package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 금액이_1000_미만이면_예외발생() {
        assertThatThrownBy(() -> new Price(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 금액이_1000_단위가_아니면_예외발생() {
        assertThatThrownBy(() -> new Price(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void 정상입력시_로또개수계산_정상() {
        Price price = new Price(3000);

        assertThat(price.toLottoCount()).isEqualTo(3);
    }

}