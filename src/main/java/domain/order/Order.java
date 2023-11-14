package domain.order;

import domain.menu.MenuItem;
import domain.menu.MenuRepository;
import exception.InvalidNumberInputException;
import exception.InvalidOrderInputException;

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
        MenuRepository menuRepository = new MenuRepository();

        if (!menuRepository.isExist(menuName)) {
            throw new InvalidOrderInputException();
        }
    }


    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
