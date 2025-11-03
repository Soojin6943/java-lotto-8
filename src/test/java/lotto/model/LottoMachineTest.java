package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @Test
    void 지정한_개수만큼_로또_생성() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.generateLottos(5);

        assertThat(lottos).hasSize(5);
        assertThat(lottos.get(0).getNumbers()).hasSize(6);
    }

    @Test
    void 로또번호_중복_확인() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.generateLotto();

        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

}