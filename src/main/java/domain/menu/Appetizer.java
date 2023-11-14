package domain.menu;

import java.util.ArrayList;
import java.util.List;

public class Appetizer {
    private List<MenuItem> appetizers = new ArrayList<>();

    public Appetizer() {
        initAppetizers();
    }

    private void initAppetizers() {
        appetizers.add(new MenuItem("양송이수프", 6_000));
        appetizers.add(new MenuItem("타파스", 5_500));
        appetizers.add(new MenuItem("시저샐러드", 8_000));
    }

    public boolean isAppetizer(String menuName) {
        for (MenuItem menuItem : appetizers) {
            if (menuItem.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public List<MenuItem> getAppetizers() {
        return appetizers;
    }

}
