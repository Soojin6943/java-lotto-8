package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Price price = new Price();

        String amountPrice = inputView.readAmountPrice();
        System.out.println(amountPrice);

        int intPrice = price.parseAmount(amountPrice);
        System.out.println(intPrice);

        int lottoCnt = price.toLottoCount(intPrice);
        System.out.println(lottoCnt);
    }
}
