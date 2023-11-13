package domain.order;

import exception.InvalidNumberInputException;

public class Order {
    private static final int ZERO = 0;
    private String menuName;
    private int quantity;

    public Order(String menuName, int quantity) {
        validate(menuName, quantity);
        this.menuName = menuName;
        this.quantity = quantity;
    }

    private void validate(String menuName, int quantity) {
        validateMenuName(menuName);
        validateQuantity(quantity);
    }

    private void validateQuantity(int quantity) {
        if (!(quantity > ZERO)) {
            throw new InvalidNumberInputException();
        }
    }

    private void validateMenuName(String menuName) {

    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
