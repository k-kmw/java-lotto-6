package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(lottoGenerator);
        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.start();
    }
}
