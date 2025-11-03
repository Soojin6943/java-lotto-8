package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 당첨번호와_일치개수_계산() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 20, 30));
        int matchCount = winningLotto.countMatch(lotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스번호_일치여부() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto lotto = new Lotto(List.of(1,2,3,7,10,11));
        assertThat(winningLotto.hasBonusMatch(lotto)).isTrue();
    }
}