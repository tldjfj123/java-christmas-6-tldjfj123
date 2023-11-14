package view;

import domain.calendar.Date;
import domain.order.OrderList;
import domain.order.OrderAmountCalculator;
import java.text.DecimalFormat;

public class OutputOrderAmountBeforeDiscountView {
    private static final String HEAD_MESSAGE = "<할인 전 총주문 금액>";
    private static final String UNIT = "원";

    public static void printView(OrderList orderList) {
        System.out.println(HEAD_MESSAGE);
        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        int orderAmountBeforeDiscount = orderAmountCalculator.getOrderAmountBeforeDiscount();

        DecimalFormat df = new DecimalFormat("###,###");
        String formatted = df.format(orderAmountBeforeDiscount);

        System.out.println(formatted + UNIT);
    }
}
