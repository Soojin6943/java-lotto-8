package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String amountPrice = inputView.readAmountPrice();
        System.out.println(amountPrice);
    }
}
