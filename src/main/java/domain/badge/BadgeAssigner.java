package domain.badge;

import domain.calendar.Date;
import domain.discount.DiscountCalculator;
import domain.gift.Gift;
import domain.gift.GiftAssigner;
import domain.menu.MenuRepository;
import domain.order.OrderAmountCalculator;
import domain.order.OrderList;

public class BadgeAssigner {
    private static final int MINIMUM_ORDER = 10_000;
    private static final int STAR_THRESHOLD = 5_000;
    private static final int TREE_THRESHOLD = 10_000;
    private static final int SANTA_THRESHOLD = 20_000;
    private static final String SANTA = "산타";
    private static final String TREE = "나무";
    private static final String STAR = "별";
    private static final String NONE = "없음";


    public static Badge assignBadge(Date date, OrderList orderList) {
        OrderAmountCalculator orderAmountCalculator = new OrderAmountCalculator(orderList);
        int orderAmountBeforeDiscount = orderAmountCalculator.getOrderAmountBeforeDiscount();
        DiscountCalculator discountCalculator = new DiscountCalculator(date, orderList);
        MenuRepository menuRepository = new MenuRepository();
        Gift gift = GiftAssigner.assignGift(orderAmountBeforeDiscount);

        int giftPrice = 0;
        if (!gift.getName().equals(NONE)) {
            giftPrice = menuRepository.findByName(gift.getName()).getPrice();
        }
        int totalBenefitAmount = discountCalculator.getDiscountAmount() + giftPrice;

        if (totalBenefitAmount >= SANTA_THRESHOLD && orderAmountBeforeDiscount >= MINIMUM_ORDER) {
            return new Badge(SANTA);
        }

        if (totalBenefitAmount >= TREE_THRESHOLD && orderAmountBeforeDiscount >= MINIMUM_ORDER) {
            return new Badge(TREE);
        }

        if (totalBenefitAmount >= STAR_THRESHOLD && orderAmountBeforeDiscount >= MINIMUM_ORDER) {
            return new Badge(STAR);
        }

        return new Badge(NONE);
    }
}
