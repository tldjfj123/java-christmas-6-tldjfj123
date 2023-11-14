package view;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.gift.Gift;
import domain.gift.GiftAssigner;
import domain.menu.MenuRepository;
import domain.order.OrderList;
import domain.order.OrderAmountCalculator;
import java.text.DecimalFormat;

public class OutputBenefitView {
    private static final String HEAD_MESSAGE = "<혜택 내역>";
    private static final String HEAD_MESSAGE_2 = "<총혜택 금액>";
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final String WEEKDAY_DISCOUNT = "평일 할인: ";
    private static final String WEEKEND_DISCOUNT = "주말 할인: ";
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final String GIFT_EVENT = "증정 이벤트: ";
    private static final String NEW_LINE = "\n";
    private static final int ZERO = 0;
    private static final String NONE = "없음";
    private static final String UNIT = "원";
    private static final String MINUS = "-";

    public static void printView(Date date, OrderList orderList) {
        System.out.println(NEW_LINE + HEAD_MESSAGE);
        DiscountCalculator discountCalculator = new DiscountCalculator(date, orderList);
        int totalDiscount = ZERO;
        boolean isBenefitApplied = false;

        int christmasDiscount = discountCalculator.getChristmasDiscount();
        totalDiscount += christmasDiscount;
        if (christmasDiscount > ZERO) {
            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(christmasDiscount);

            System.out.println(CHRISTMAS_DISCOUNT + MINUS + formatted + UNIT);
            isBenefitApplied = true;
        }

        int weekdayDiscount = discountCalculator.getWeekdayDiscount();
        totalDiscount += weekdayDiscount;
        if (weekdayDiscount > ZERO) {
            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(weekdayDiscount);

            System.out.println(WEEKDAY_DISCOUNT + MINUS + formatted + UNIT);
            isBenefitApplied = true;
        }

        int weekendDiscount = discountCalculator.getWeekendDiscount();
        totalDiscount += weekendDiscount;
        if (weekendDiscount > ZERO) {
            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(weekendDiscount);

            System.out.println(WEEKEND_DISCOUNT + MINUS + formatted + UNIT);
            isBenefitApplied = true;
        }

        int specialDiscount = discountCalculator.getSpecialDiscount();
        totalDiscount += specialDiscount;
        if (specialDiscount > ZERO) {
            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(specialDiscount);

            System.out.println(SPECIAL_DISCOUNT + MINUS + formatted + UNIT);
            isBenefitApplied = true;
        }

        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        Gift gift = GiftAssigner.assignGift(orderAmountCalculator.getOrderAmountBeforeDiscount());
        if (!(gift.getName().equals(NONE))) {
            MenuRepository menuRepository = new MenuRepository();
            int price = menuRepository.findByName(gift.getName()).getPrice();

            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(price);

            System.out.println(GIFT_EVENT + MINUS + formatted + UNIT);
            isBenefitApplied = true;
        }

        if (isBenefitApplied) {
            System.out.println(NEW_LINE + HEAD_MESSAGE_2);
            MenuRepository menuRepository = new MenuRepository();
            int giftPrice = menuRepository.findByName(gift.getName()).getPrice();
            int totalDiscountAmount = discountCalculator.getDiscountAmount() + giftPrice;

            DecimalFormat df = new DecimalFormat("###,###");
            String formatted = df.format(totalDiscountAmount);

            System.out.println(MINUS + formatted + UNIT);
        }

        if (!isBenefitApplied) {
            System.out.println(NONE);
            System.out.println(NEW_LINE + HEAD_MESSAGE_2);
            System.out.println(NONE);

        }



    }

}
