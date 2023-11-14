package view;

import domain.order.Order;
import domain.order.OrderList;

public class OutputOrderListView {
    private static final String HEAD_MESSAGE = "<주문 메뉴>";
    private static final String UNIT = "개";
    public static void printView(OrderList orderList) {
        System.out.println(HEAD_MESSAGE);
        for (Order order : orderList.getOrderList()) {
            String menuName = order.getMenuName();
            int quantity = order.getQuantity();

            System.out.println(menuName + " " + quantity + UNIT);
        }
    }
}
