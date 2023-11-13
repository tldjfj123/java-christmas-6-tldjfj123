package domain.discount;

import exception.InvalidNumberInputException;

public class ChristmasDiscount {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private static final int START_DISCOUNT = 1000;
    private static final int INCREASE_AMOUNT = 100;
    private static final int CHRISTMAS_DISCOUNT_MAX = 3400;
    private int discountAmount;


    public ChristmasDiscount(int date) {
        validate(date);
        calcDiscountAmount(date);
    }

    private void validate(int date) {
        validateDateRange(date);
    }

    private void validateDateRange(int date) {
        if (!(MIN_DATE <= date && date <= MAX_DATE)) {
            throw new InvalidNumberInputException();
        }
    }

    private void calcDiscountAmount(int date) {
        int dateInterval = date - 1;
        this.discountAmount = Math.min((START_DISCOUNT + INCREASE_AMOUNT * dateInterval), CHRISTMAS_DISCOUNT_MAX);
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
