package domain.menu;

import java.util.ArrayList;
import java.util.List;

public class Dessert {
    private List<MenuItem> desserts = new ArrayList<>();

    public Dessert() {
        initDesserts();
    }

    private void initDesserts() {
        desserts.add(new MenuItem("초코케이크", 15_000));
        desserts.add(new MenuItem("아이스크림", 5_000));
    }

    public boolean isDessert(String menuName) {
        for (MenuItem menuItem : desserts) {
            if (menuItem.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public List<MenuItem> getDesserts() {
        return desserts;
    }
}
