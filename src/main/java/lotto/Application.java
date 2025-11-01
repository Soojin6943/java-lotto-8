package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Parser parser = new Parser();

        while (true) {
            try {
                // 문자열로 입력받은 구매 금액
                String amountPrice = inputView.readAmountPrice();
                System.out.println(amountPrice);

                // 문자열 구매 금액 -> 정수 구매금액
                int intPrice = parser.parseAmount(amountPrice);
                System.out.println(intPrice);

                // 구매 금액을 가격으로
                Price price = new Price(intPrice);
                int lottoCnt = price.toLottoCount();
                System.out.println(lottoCnt);
                return;
            } catch (IllegalArgumentException e) {
                // TODO view로 변경하기
                System.out.println(e.getMessage());
            }
        }
    }
}
