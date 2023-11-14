package domain.discount;

public class WeekendDiscount {
    private static final int DISCOUNT_AMOUNT = 2023;

    public static int calculateDiscount(int quantity) {
        return DISCOUNT_AMOUNT * quantity;
    }
}
