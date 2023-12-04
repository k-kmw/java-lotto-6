package lotto.model;

import java.util.List;

public class WinnerLottoNumber {

    private final List<Integer> winnerNumbers;

    public WinnerLottoNumber(List<Integer> winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
