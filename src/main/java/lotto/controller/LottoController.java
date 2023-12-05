package lotto.controller;

import lotto.model.*;
import lotto.model.dto.UserInput;
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
        PurchasePrice purchasePrice = getPurchasePrice();
        List<Lotto> purchasedLottos = LottoGenerator.generateLotto(purchasePrice);
        outputView.printPurchasedLottosNumber(purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();

        List<Result> results = getResults(purchasedLottos, winningLotto);

        outputView.printWinnerStatics(results);
        outputView.printTotalBenefit(results, purchasePrice);
    }

    private List<Result> getResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            Result result = purchasedLotto.match(winningLotto);
            results.add(result);
        }
        return results;
    }

    private WinningLotto getWinningLotto() {
        while(true) {
            try {
                 return new WinningLotto(getLotto(), getBonusNum());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 로또 생성 에러");
            }
        }
    }

    private BonusNum getBonusNum() {
        while (true) {
            try {
                outputView.printBonusNumberMessage();
                UserInput.BonusNumDTO bonusNumDTO = new UserInput.BonusNumDTO(inputView.inputString());
                return new BonusNum(bonusNumDTO.getBonusNum());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호 에러");
            }
        }
    }

    private Lotto getLotto() {
        while (true) {
            try {
                outputView.printWinnerNumberMessage();
                String winnerNumber = inputView.inputString();
                UserInput.WinnerNumbersDTO winnerNumbersDTO = new UserInput.WinnerNumbersDTO(winnerNumber);
                return new Lotto(winnerNumbersDTO.toList());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호 에러");
            }
        }
    }

    private PurchasePrice getPurchasePrice() {
        while (true) {
            try {
                outputView.printInputPurchasePriceMessage();
                UserInput.purchasePriceDTO purchasePriceDTO = new UserInput.purchasePriceDTO(inputView.inputString());
                return new PurchasePrice(purchasePriceDTO.getPrice());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 구매 금액 에러");
            }
        }
    }
}
