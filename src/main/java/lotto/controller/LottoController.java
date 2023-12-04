package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        String userInputPurchasePrice = inputView.inputPurchasePrice();
        PurchasePrice purchasePrice = new PurchasePrice(userInputPurchasePrice);
        List<Lotto> purchasedLottos = LottoGenerator.generateLotto(purchasePrice);
        outputView.printPurchasedLottosNumber(purchasedLottos);
        outputView.printWinnerNumberMessage();
        String winnerNumber = inputView.inputWinnerNumber();
        WinnerLottoNumber winnerLottoNumber = new WinnerLottoNumber(winnerNumber);
        outputView.printBonusNumberMesssage();
        String bonusNumber = inputView.inputBonusNumber();
        BonusNum bonusNum = new BonusNum(bonusNumber);
        LottoDrawer lottoDrawer = new LottoDrawer();
        List<Result> results = lottoDrawer.award(purchasedLottos, winnerLottoNumber, bonusNum);
        outputView.printWinnerStatics(results, purchasePrice);
    }
}
