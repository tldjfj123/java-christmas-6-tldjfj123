package domain.discount;

public class WeekdayDiscount {
    private static final int DISCOUNT_AMOUNT = 2023;

    public int calculateDiscount(int quantity) {
        return DISCOUNT_AMOUNT * quantity;
    }
}
