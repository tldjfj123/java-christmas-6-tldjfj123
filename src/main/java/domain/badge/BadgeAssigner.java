package domain.badge;

import domain.order.OrderAmountCalculator;

public class BadgeAssigner {
    private static final int MINIMUM_ORDER = 10_000;
    private static final int STAR_THRESHOLD = 5_000;
    private static final int TREE_THRESHOLD = 10_000;
    private static final int SANTA_THRESHOLD = 20_000;
    private static final String SANTA = "산타";
    private static final String TREE = "나무";
    private static final String STAR = "별";
    private static final String NONE = "없음";


    public static Badge assignBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA_THRESHOLD) {
            return new Badge(SANTA);
        }

        if (totalBenefitAmount >= TREE_THRESHOLD) {
            return new Badge(TREE);
        }

        if (totalBenefitAmount >= STAR_THRESHOLD && OrderAmountCalculator.getOrderAmountBeforeDiscount() >= MINIMUM_ORDER) {
            return new Badge(STAR);
        }

        return new Badge(NONE);
    }
}
