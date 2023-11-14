package domain.menu;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private List<MenuItem> drinks = new ArrayList<>();

    public Drink() {
        initDrinks();
    }

    private void initDrinks() {
        drinks.add(new MenuItem("제로콜라", 3_000));
        drinks.add(new MenuItem("레드와인", 60_000));
        drinks.add(new MenuItem("샴페인", 25_000));
    }

    public boolean isDrink(String menuName) {
        for (MenuItem menuItem : drinks) {
            if (menuItem.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public List<MenuItem> getDrinks() {
        return drinks;
    }
}
