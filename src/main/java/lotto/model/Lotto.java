package lotto.model;

import java.util.Collections;
import java.util.HashSet;
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
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자 존재");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Result match(WinningLotto winnerLotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        for (Integer number : numbers) {
            for (Integer winnerNumber : winnerLotto.getLotto().getNumbers()) {
                if (number.equals(winnerNumber)) {
                    matchCount++;
                }
            }
            if (number == winnerLotto.getBonusNum().getNum()) {
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
