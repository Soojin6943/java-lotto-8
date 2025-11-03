package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Parser;
import lotto.model.Price;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final Parser parser = new Parser();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        Price price = validPrice();

        int lottoCnt = price.toLottoCount();
        OutputView.printLottoCount(lottoCnt);

        List<Lotto> lottos = lottoMachine.generateLottos(lottoCnt);
        OutputView.printLottos(lottos);

        WinningNumbers winningNumbers = validWinningNumbers();
    }

    private Price validPrice() {
        while (true) {
            try {
                String amountPrice = inputView.readAmountPrice();
                int intPrice = parser.parseAmount(amountPrice);
                Price price = new Price(intPrice);
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers validWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.readWinningNumbers();
                WinningNumbers winningNumbers = new WinningNumbers(parser.parseWinningNumbers(inputWinningNumbers));
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
