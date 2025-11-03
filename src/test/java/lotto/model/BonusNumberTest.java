package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다")
    void 보너스_번호가_당첨_번호와_중복이면_예외발생() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(3, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("범위를 벗어난 번호가 있으면 예외 발생")
    void 범위를_벗어난_번호가_있으면_예외발생() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new BonusNumber(0, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);

        assertThatThrownBy(() -> new BonusNumber(46, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("정상 입력 시 정상적으로 저장된다.")
    void 정상_입력시_정상적인_저장() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }
}