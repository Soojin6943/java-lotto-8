package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 결과_집계() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8))
        );

        // when
        LottoResult result = new LottoResult(lottos, winningLotto);
        Map<Rank, Integer> resultMap = result.getResultMap();

        // then
        assertThat(resultMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(resultMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(resultMap.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_확인() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3,4 ,5,6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );

        LottoResult result = new LottoResult(lottos, winningLotto);
        double rate = result.calculateProfitRate(2000);

        assertThat(rate).isEqualTo(1000000.0);
    }
}