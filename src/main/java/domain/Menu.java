package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> appetizers;
    private List<MenuItem> mains;
    private List<MenuItem> desserts;
    private List<MenuItem> drinks;

    public Menu() {
        this.appetizers = new ArrayList<>();
        this.mains = new ArrayList<>();
        this.desserts = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addAppetizers(MenuItem item) {
        this.appetizers.add(item);
    }

    public void addMains(MenuItem item) {
        this.mains.add(item);
    }

    public void addDesserts(MenuItem item) {
        this.desserts.add(item);
    }

    public void addDrinks(MenuItem item) {
        this.drinks.add(item);
    }

    public List<MenuItem> getAppetizers() {
        return appetizers;
    }

    public List<MenuItem> getMains() {
        return mains;
    }

    public List<MenuItem> getDesserts() {
        return desserts;
    }

    public List<MenuItem> getDrinks() {
        return drinks;
    }
}
