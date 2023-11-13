package domain.gift;

import domain.gift.Gift;

public class GiftAssigner {
    private static final int MINIMUM_GIFT_AMOUNT = 120_000;
    private static final String GIFT = "샴페인";
    private static final String NONE = "없음";

    public Gift assignGift(int totalAmount) {
        if (totalAmount >= MINIMUM_GIFT_AMOUNT) {
            return new Gift(GIFT);
        }

        return new Gift(NONE);
    }

}
