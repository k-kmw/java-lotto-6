package lotto.model;

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
        if (price % 1000 != 0 || price < 1000) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
