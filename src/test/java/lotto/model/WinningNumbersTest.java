package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    void 당첨_번호가_6개가_아니면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

    }

    @Test
    @DisplayName("중복된 번호가 있으면 예외가 발생한다.")
    void 중복된_번호가_있으면_예외_발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("범위를 벗어난 번호가 있으면 예외 발생")
    void 범위를_벗어난_번호가_있으면_예외발생() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 1, 2, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("정상 입력 시 정상적으로 저장된다.")
    void 정상_입력시_정상적인_저장() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));

        assertThat(winningNumbers.getWinningNumbers()).containsExactly(1,2,3,4,5,6);
    }

}