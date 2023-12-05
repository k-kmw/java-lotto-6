package lotto.view;

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

    public void printWinnerStatics(List<Result> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(Result.FIFTH.getMatchCount() + "개 일치 (" + formatter.format(Result.FIFTH.getAward()) + "원) - " + results.stream().filter(res -> res == Result.FIFTH).count() + "개");
        System.out.println(Result.FOURTH.getMatchCount() + "개 일치 (" + formatter.format(Result.FOURTH.getAward()) + "원) - " + results.stream().filter(res -> res == Result.FOURTH).count() + "개");
        System.out.println(Result.THIRD.getMatchCount() + "개 일치 (" + formatter.format(Result.THIRD.getAward()) + "원) - " + results.stream().filter(res -> res == Result.THIRD).count() + "개");
        System.out.println(Result.SECOND.getMatchCount() + "개 일치 (" + formatter.format(Result.SECOND.getAward()) + "원) - " + results.stream().filter(res -> res == Result.SECOND).count() + "개");
        System.out.println(Result.FIRST.getMatchCount() + "개 일치 (" + formatter.format(Result.FIRST.getAward()) + "원) - " + results.stream().filter(res -> res == Result.FIRST).count() + "개");
    }

    public void printTotalBenefit(List<Result> results, PurchasePrice purchasePrice) {
        double totalAward = results.stream()
                .mapToInt(Result::getAward)
                .sum();
        System.out.println("총 수익률은 "+ totalAward/purchasePrice.getPrice() + "% 입니다.");
    }
}
