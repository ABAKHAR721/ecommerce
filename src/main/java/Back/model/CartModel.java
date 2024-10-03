package Back.model;

public class CartModel extends Product {
    private int quantity;
    public CartModel(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
