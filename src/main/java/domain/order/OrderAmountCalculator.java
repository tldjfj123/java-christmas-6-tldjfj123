package domain.order;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.menu.MenuRepository;

public class OrderAmountCalculator {
    private int orderAmountBeforeDiscount;

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

    public int getOrderAmountBeforeDiscount() {
        return orderAmountBeforeDiscount;
    }
}

