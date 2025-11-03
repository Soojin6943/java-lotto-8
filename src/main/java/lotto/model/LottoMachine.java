package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

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
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT));
    }
}
