package domain.discount;

import domain.calendar.Date;
import domain.menu.Dessert;
import domain.menu.Main;
import domain.order.Order;
import domain.order.OrderList;

public class DiscountCalculator {
    private static final int ZERO = 0;
    private static final int CHRISTMAS_MAX = 25;
    private int discountAmount = ZERO;
    private int christmasDiscount = ZERO;
    private int weekendDiscount = ZERO;
    private int weekdayDiscount = ZERO;
    private int specialDiscount = ZERO;

    public DiscountCalculator(Date date, OrderList orderList) {
        calculateDiscounts(date, orderList);
    }

    private void calculateDiscounts(Date date, OrderList orderList) {
        calculateChristmasDiscount(date);
        calculateSpecialDiscount(date);
        calculateWeekdayDiscount(date, orderList);
        calculateWeekendDiscount(date, orderList);
    }

    public void calculateWeekdayDiscount(Date date, OrderList orderList) {
        if (!date.isWeekend()) {
            int dessertCount = countDesserts(orderList);
            weekdayDiscount += WeekdayDiscount.calculateDiscount(dessertCount);
            discountAmount += weekdayDiscount;
        }

    }

    private int countDesserts(OrderList orderList) {
        Dessert dessert = new Dessert();
        int dessertCount = 0;

        for (Order order : orderList.getOrderList()) {
            if (dessert.isDessert(order.getMenuName())) {
                dessertCount += order.getQuantity();
            }
        }

        return dessertCount;
    }

    public void calculateWeekendDiscount(Date date, OrderList orderList) {
        if (date.isWeekend()) {
            int mainCount = countMains(orderList);
            weekendDiscount += WeekendDiscount.calculateDiscount(mainCount);
            discountAmount += weekendDiscount;
        }


    }

    private int countMains(OrderList orderList) {
        Main main = new Main();
        int mainCount = 0;

        for (Order order : orderList.getOrderList()) {
            if (main.isMain(order.getMenuName())) {
                mainCount += order.getQuantity();
            }
        }

        return mainCount;
    }

    public void calculateChristmasDiscount(Date date) {
        if (date.getDate() <= CHRISTMAS_MAX) {
            ChristmasDiscount christmas = new ChristmasDiscount(date.getDate());
            christmasDiscount += christmas.getDiscountAmount();
            discountAmount += christmasDiscount;
        }

    }

    public void calculateSpecialDiscount(Date date) {
        if (date.isHasStar()) {
            specialDiscount +=  SpecialDiscount.DISCOUNT_AMOUNT;
            discountAmount += specialDiscount;
        }
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
}
