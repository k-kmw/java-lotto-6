package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;

    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printInputPurchasePriceMessage();
        String userInputPurchasePrice = inputView.inputString();
        PurchasePrice purchasePrice = new PurchasePrice(userInputPurchasePrice);
        List<Lotto> purchasedLottos = LottoGenerator.generateLotto(purchasePrice);
        outputView.printPurchasedLottosNumber(purchasedLottos);
        outputView.printWinnerNumberMessage();
        String winnerNumber = inputView.inputString();
        WinnerLottoNumber winnerLottoNumber = new WinnerLottoNumber(winnerNumber);
        outputView.printBonusNumberMessage();
        String bonusNumber = inputView.inputString();
        BonusNum bonusNum = new BonusNum(bonusNumber);
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerLottoNumber, bonusNum);
            results.add(result);
        }
        outputView.printWinnerStatics(results);
        outputView.printTotalBenefit(results, purchasePrice);
    }
}
