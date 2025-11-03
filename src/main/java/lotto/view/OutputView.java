package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Rank;

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

    public static void printResult(LottoResult result, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> resultMap = result.getResultMap();

        System.out.println("3개 일치 (5,000원) - " + resultMap.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + resultMap.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.getOrDefault(Rank.FIRST, 0) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate * 100) + "%입니다.");
    }
}
