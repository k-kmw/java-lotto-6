package lotto.model;

public enum Result {

    FIRST(6, false, 2000000000), SECOND(5, true, 30000000),
    THIRD(5, false, 1500000), FOURTH(4, false, 50000),
    FIFTH(3, false, 5000), OTHER(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int award;

    Result(int matchCount, boolean matchBonus, int award) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.award = award;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getAward() {
        return award;
    }
}
