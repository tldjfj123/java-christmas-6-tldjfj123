package domain.calendar;

import exception.InvalidNumberInputException;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;
    private int date;
    private boolean hasStar;
    private boolean isWeekend;

    public Date(int date, boolean hasStar, boolean isWeekend) {
        validate(date);
        this.date = date;
        this.hasStar = hasStar;
        this.isWeekend = isWeekend;
    }

    private void validate(int date) {
        validateDateRange(date);
    }

    private void validateDateRange(int date) {
        if (!(MIN_DATE <= date && date <= MAX_DATE)) {
            throw new InvalidNumberInputException();
        }
    }

    public int getDate() {
        return date;
    }

    public boolean isHasStar() {
        return hasStar;
    }

    public void setHasStar(boolean hasStar) {
        this.hasStar = hasStar;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
