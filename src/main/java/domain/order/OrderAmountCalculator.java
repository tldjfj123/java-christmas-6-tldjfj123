package domain.order;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.menu.MenuRepository;

public class OrderAmountCalculator {
    private static int orderAmountBeforeDiscount;

    public OrderAmountCalculator(OrderList orderList) {
        calculateOrderAmountBeforeDiscount(orderList);
    }

    private void calculateOrderAmountBeforeDiscount(OrderList orderList) {
        MenuRepository menuRepository = new MenuRepository();
        for (Order order : orderList.getOrderList()) {
            orderAmountBeforeDiscount +=
                    (order.getQuantity()) * menuRepository.findByName(order.getMenuName()).getPrice();
        }
    }

    public static int getOrderAmountBeforeDiscount() {
        return orderAmountBeforeDiscount;
    }

    public static void setOrderAmountBeforeDiscount(int orderAmountBeforeDiscount) {
        OrderAmountCalculator.orderAmountBeforeDiscount = orderAmountBeforeDiscount;
    }
}
