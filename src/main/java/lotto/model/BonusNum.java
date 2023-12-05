package lotto.model;

public class BonusNum {

    private final int num;

    public BonusNum(String num) {
//        validate(num);
        this.num = Integer.parseInt(num);
    }

    public int getNum() {
        return num;
    }
}
