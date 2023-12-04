package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateLotto(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottos.add(lotto);
        return lottos;
    }
}
