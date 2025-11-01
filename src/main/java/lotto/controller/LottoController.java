package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.LottoMachine;
import lotto.Parser;
import lotto.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        while (true) {
            try {
                // 문자열로 입력받은 구매 금액
                String amountPrice = inputView.readAmountPrice();

                // 문자열 구매 금액 -> 정수 구매금액
                int intPrice = parser.parseAmount(amountPrice);

                // 구매 금액을 가격으로
                Price price = new Price(intPrice);
                int lottoCnt = price.toLottoCount();
                OutputView.printLottoCount(lottoCnt);

                // 로또
                List<Lotto> lottos = lottoMachine.generateLottos(lottoCnt);
                OutputView.printLottos(lottos);
                break;
            } catch (IllegalArgumentException e) {
                // TODO view로 변경하기
                System.out.println(e.getMessage());
            }
        }
    }
}
