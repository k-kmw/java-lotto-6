package lotto.model;

public class PurchasePrice {

    private final int price;

    public PurchasePrice(String price) {
        validate(price);
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return price;
    }

    private void validate(String userInput) {
        int price = Integer.parseInt(userInput);
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
