package lotto.model;

public class BonusNum {

    private final int num;

    public BonusNum(String num) {
        validate(num);
        this.num = Integer.parseInt(num);
    }

    public int getNum() {
        return num;
    }

    private void validate(String userInput) {
        int num = Integer.parseInt(userInput);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("범위를 벗어난 숫자");
        }
    }
}
