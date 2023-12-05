package lotto.model;

import lotto.constant.Constant;

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
        if (userInput < Constant.MIN_LOTTO_NUM || userInput > Constant.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("범위를 벗어난 숫자");
        }
    }
}
