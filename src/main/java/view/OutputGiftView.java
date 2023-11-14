package view;

import domain.calendar.Date;
import domain.gift.Gift;
import domain.gift.GiftAssigner;
import domain.order.OrderList;
import domain.order.OrderAmountCalculator;

public class OutputGiftView {
    private static final String HEAD_MESSAGE = "<증정 메뉴>";
    private static final String NEW_LINE = "\n";
    private static final String UNIT = " 1개";
    private static final String NONE = "없음";

    public static void printView(OrderList orderList) {
        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        System.out.println(NEW_LINE + HEAD_MESSAGE);

        Gift gift = GiftAssigner.assignGift(orderAmountCalculator.getOrderAmountBeforeDiscount());

        System.out.println(selectMessage(gift));
    }

    public static String selectMessage(Gift gift) {
        if (gift.getName().equals(NONE)) {
            return NONE;
        }

        return gift.getName() + UNIT;
    }
}
