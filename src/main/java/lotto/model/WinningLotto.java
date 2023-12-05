package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNum bonusNum;

    public WinningLotto(Lotto lotto, BonusNum bonusNum) {
        validate(lotto, bonusNum);
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNum getBonusNum() {
        return bonusNum;
    }

    private void validate(Lotto lotto, BonusNum bonusNum) {
        boolean duplicated = lotto.getNumbers().stream()
                .anyMatch(num -> num == bonusNum.getNum());
        if (duplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호가 중복");
        }
    }
}
