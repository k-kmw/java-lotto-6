package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> generateLotto(PurchasePrice purchasePrice) {
        return lottoGenerator.generateLotto(purchasePrice);
    }

    public List<Result> getResults(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        for (Lotto purchasedLotto : purchasedLottos) {
            Result result = purchasedLotto.match(winningLotto);
            results.add(result);
        }
        return results;
    }
}
