package view;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.order.OrderList;
import domain.order.OrderAmountCalculator;
import java.text.DecimalFormat;

public class OutputOrderAmountAfterDiscountView {
    private static final String HEAD_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String MINUS = "-";
    private static final String UNIT = "원";
    private static final String NEW_LINE = "\n";

    public static void printView(Date date, OrderList orderList) {
        System.out.println(NEW_LINE + HEAD_MESSAGE);
        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        int amountBeforeDiscount = orderAmountCalculator.getOrderAmountBeforeDiscount();
        DiscountCalculator discountCalculator = new DiscountCalculator(date, orderList);
        int discountAmount = discountCalculator.getDiscountAmount();

        int amountAfterDiscount = amountBeforeDiscount - discountAmount;

        DecimalFormat df = new DecimalFormat("###,###");
        String formatted = df.format(amountAfterDiscount);

        System.out.println(formatted + UNIT);


    }
}
