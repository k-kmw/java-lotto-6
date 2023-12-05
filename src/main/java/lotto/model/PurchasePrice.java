package lotto.model;

public class PurchasePrice {

    private final int price;

    public PurchasePrice(String price) {
        this.price = Integer.parseInt(price);
    }

    public int getPrice() {
        return price;
    }
}
