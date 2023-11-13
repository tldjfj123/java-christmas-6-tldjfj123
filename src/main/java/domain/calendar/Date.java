package domain.calendar;

public class Date {
    private int date;
    private boolean hasStar;
    private boolean isWeekend;

    public Date(int date, boolean hasStar, boolean isWeekend) {
        this.date = date;
        this.hasStar = hasStar;
        this.isWeekend = isWeekend;
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
