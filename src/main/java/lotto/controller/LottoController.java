package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.Parser;
import lotto.model.Price;
import lotto.model.WinningLotto;
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
        BonusNumber bonusNumber = validBonusNumber(winningNumbers);

        getResult(winningNumbers, bonusNumber, lottos, price);
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

    private BonusNumber validBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                String bonus = inputView.readBonusNumber();
                int number = parser.parseBonusNumber(bonus);
                BonusNumber bonusNumber = new BonusNumber(number, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, List<Lotto> lottos, Price price) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        double profitRate = lottoResult.calculateProfitRate(price.getValue());

        OutputView.printResult(lottoResult, profitRate);
    }
}
