package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {
    public static void printLottoCount(int lottoCnt) {
        System.out.println(lottoCnt + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            String formatted = numbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(formatted);
        }
    }
}
