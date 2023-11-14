package domain.order;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.menu.MenuRepository;
import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private int orderAmountBeforeDiscount;
    private int orderAmountAfterDiscount;

    public OrderProcessor(Date date, OrderList orderList) {
        calculateOrderAmountBeforeDiscount(orderList);
        calculateOrderAmountAfterDiscount(date, orderList);
    }

    private void calculateOrderAmountBeforeDiscount(OrderList orderList) {
        MenuRepository menuRepository = new MenuRepository();
        for (Order order : orderList.getOrderList()) {
            orderAmountBeforeDiscount +=
                    (order.getQuantity()) * menuRepository.findByName(order.getMenuName()).getPrice();
        }
    }

    private void calculateOrderAmountAfterDiscount(Date date, OrderList orderList) {
        DiscountCalculator discountCalculator = new DiscountCalculator(date, orderList);
        orderAmountAfterDiscount = orderAmountBeforeDiscount - discountCalculator.getDiscountAmount();
    }

    public int getOrderAmountBeforeDiscount() {
        return orderAmountBeforeDiscount;
    }

    public int getOrderAmountAfterDiscount() {
        return orderAmountAfterDiscount;
    }
}
