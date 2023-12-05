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
        int matchCount = calculateMatchCount(winnerLotto.getLotto());
        boolean matchBonus = isHitBonusNum(winnerLotto.getBonusNum());
        return getResult(matchCount, matchBonus);
    }

    private int calculateMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private boolean isHitBonusNum(BonusNum bonusNum) {
        return numbers.contains(bonusNum.getNum());
    }

    private Result getResult(int matchCount, boolean matchBonus) {
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
