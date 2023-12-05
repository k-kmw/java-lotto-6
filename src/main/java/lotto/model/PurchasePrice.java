package lotto.model;

import lotto.constant.Constant;

public class PurchasePrice {

    private final int price;

    public PurchasePrice(int price) {
        validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validate(int price) {
        if (price % Constant.LOTTO_PRICE != 0 || price < Constant.LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
