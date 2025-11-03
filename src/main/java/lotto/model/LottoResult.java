package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import javax.print.DocFlavor.STRING;

public class LottoResult {
    private final Map<Rank, Integer> resultMap = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.countMatch(lotto);
            boolean hasBonus = winningLotto.hasBonusMatch(lotto);
            Rank rank = Rank.valueOf(matchCount, hasBonus);
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / purchaseAmount;
    }
}
