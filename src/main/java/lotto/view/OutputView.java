package lotto.view;

import lotto.constant.Constant;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import lotto.model.Result;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void printInputPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottosNumber(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getNumbers());
        }
    }

    public void printWinnerNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatics(List<Result> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat formatter = new DecimalFormat(Constant.NUMBER_FORMAT_PATTERN);
        printWinningStatic(formatter, results, Result.FIFTH);
        printWinningStatic(formatter, results, Result.FOURTH);
        printWinningStatic(formatter, results, Result.THIRD);
        printWinningStatic(formatter, results, Result.SECOND);
        printWinningStatic(formatter, results, Result.FIRST);
    }

    public void printTotalBenefit(List<Result> results, PurchasePrice purchasePrice) {
        double totalAward = results.stream()
                .mapToInt(Result::getAward)
                .sum();
        System.out.println("총 수익률은 "+ (totalAward/purchasePrice.getPrice())*100 + "%입니다.");
    }

    private void printWinningStatic(DecimalFormat formatter, List<Result> results, Result result) {
        long count = results.stream()
                .filter(res -> res == result)
                .count();
        if (result == Result.SECOND) {
            System.out.println(result.getMatchCount() + "개 일치, 보너스 볼 일치 (" + formatter.format(result.getAward()) + "원) - " + count + "개");
            return;
        }
        System.out.println(result.getMatchCount() + "개 일치 (" + formatter.format(result.getAward()) + "원) - " + count + "개");
    }
}
