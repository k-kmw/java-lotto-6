package lotto.model;

import lotto.constant.Constant;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Result match(WinningLotto winnerLotto) {
        int matchCount = calculateMatchCount(winnerLotto.getLotto());
        boolean matchBonus = isHitBonusNum(winnerLotto.getBonusNum());
        return getResult(matchCount, matchBonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자 존재");
        }
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
        if (matchCount == Result.FIRST.getMatchCount()) {
            return Result.FIRST;
        }
        if (matchCount == Result.SECOND.getMatchCount() && matchBonus) {
            return Result.SECOND;
        }
        if (matchCount == Result.THIRD.getMatchCount()) {
            return Result.THIRD;
        }
        if (matchCount == Result.FOURTH.getMatchCount()) {
            return Result.FOURTH;
        }
        if (matchCount == Result.FIFTH.getMatchCount()) {
            return Result.FIFTH;
        }
        return Result.OTHER;
    }
}
