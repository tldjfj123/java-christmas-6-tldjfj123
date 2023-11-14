package view;

import domain.badge.Badge;
import domain.badge.BadgeAssigner;
import domain.calendar.Date;
import domain.order.OrderList;
import domain.order.OrderAmountCalculator;

public class OutputBadgeView {
    private static final String HEAD_MESSAGE = "<12월 이벤트 배지>";
    private static final String NEW_LINE = "\n";
    public static void printView(OrderList orderList) {
        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        int orderAmountBeforeDiscount = orderAmountCalculator.getOrderAmountBeforeDiscount();

        Badge badge = BadgeAssigner.assignBadge(orderAmountBeforeDiscount);

        System.out.println(NEW_LINE + HEAD_MESSAGE);
        System.out.println(badge.getName());
    }
}
