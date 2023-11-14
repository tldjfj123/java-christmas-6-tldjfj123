package domain.menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<MenuItem> mains = new ArrayList<>();

    public Main() {
        initMains();
    }

    private void initMains() {
        mains.add(new MenuItem("티본스테이크", 55_000));
        mains.add(new MenuItem("바비큐립", 54_000));
        mains.add(new MenuItem("해산물파스타", 35_000));
        mains.add(new MenuItem("크리스마스파스타", 25_000));
    }

    public boolean isMain(String menuName) {
        for (MenuItem menuItem : mains) {
            if (menuItem.getName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public List<MenuItem> getMains() {
        return mains;
    }
}
