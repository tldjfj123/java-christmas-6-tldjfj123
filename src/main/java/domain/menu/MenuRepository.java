package domain.menu;

import exception.InvalidOrderInputException;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuRepository() {
        initMenuRepository();
    }

    private void initMenuRepository() {
        Appetizer appetizer = new Appetizer();
        Dessert dessert = new Dessert();
        Drink drink = new Drink();
        Main main = new Main();

        menuItems.addAll(appetizer.getAppetizers());
        menuItems.addAll(dessert.getDesserts());
        menuItems.addAll(drink.getDrinks());
        menuItems.addAll(main.getMains());
    }

    public boolean isExist(String menuName) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equals(menuName)) {
                return true;
            }
        }

        return false;
    }

    public MenuItem findByName(String menuName) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equals(menuName)) {
                return menuItem;
            }
        }

        throw new InvalidOrderInputException();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
