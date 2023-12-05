package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerLottoNumber {

    private final List<Integer> winnerNumbers;

    public WinnerLottoNumber(String winnerNumbers) {
//        validate(winnerNumbers);
        this.winnerNumbers = Arrays.stream(winnerNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinnerNumbers() {
        return winnerNumbers;
    }
}
