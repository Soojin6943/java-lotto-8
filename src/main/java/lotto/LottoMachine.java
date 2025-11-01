package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public Lotto lottoGenerate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
