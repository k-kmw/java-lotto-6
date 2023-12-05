package lotto.controller;

import lotto.model.*;
import lotto.model.dto.UserInput;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        PurchasePrice purchasePrice = inputPurchasePrice();
        List<Lotto> purchasedLottos = lottoService.generateLotto(purchasePrice);
        outputView.printPurchasedLottosNumber(purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();

        List<Result> results = lottoService.getResults(purchasedLottos, winningLotto);

        outputView.printWinnerStatics(results);
        outputView.printTotalBenefit(results, purchasePrice);
    }

    private PurchasePrice inputPurchasePrice() {
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

    private WinningLotto getWinningLotto() {
        while(true) {
            try {
                 return new WinningLotto(inputLotto(), inputBonusNum());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 로또 생성 에러");
            }
        }
    }

    private Lotto inputLotto() {
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

    private BonusNum inputBonusNum() {
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
}
