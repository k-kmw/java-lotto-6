package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Result match(WinnerLottoNumber winnerLottoNumber, BonusNum bonusNum) {
        int matchCount = 0;
        boolean matchBonus = false;
        for (Integer number : numbers) {
            for (Integer winnerNumber : winnerLottoNumber.getWinnerNumbers()) {
                if (number.equals(winnerNumber)) {
                    matchCount++;
                }
            }
            if (number == bonusNum.getNum()) {
                matchBonus = true;
            }
        }
        if (matchCount == 6) {
            return Result.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Result.SECOND;
        }
        if (matchCount == 5) {
            return Result.THIRD;
        }
        if (matchCount == 4) {
            return Result.FOURTH;
        }
        if (matchCount == 3) {
            return Result.FIFTH;
        }
        return Result.OTHER;
    }
}
