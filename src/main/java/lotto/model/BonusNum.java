package lotto.model;

public class BonusNum {

    private final int num;

    public BonusNum(int num) {
        validate(num);
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    private void validate(int userInput) {
        if (userInput < 1 || userInput > 45) {
            throw new IllegalArgumentException("범위를 벗어난 숫자");
        }
    }
}
