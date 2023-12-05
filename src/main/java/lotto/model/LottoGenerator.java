package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLotto(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseNum = purchasePrice.getPrice() / Constant.LOTTO_PRICE;
        for(int i=0; i<purchaseNum; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUM, Constant.MAX_LOTTO_NUM, Constant.LOTTO_NUMBER_COUNT));
            lottos.add(lotto);
        }
        return lottos;
    }
}
