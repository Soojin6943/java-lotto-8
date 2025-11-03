package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    public List<Lotto> generateLottos(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = randomNumbers();
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
