package domain.calendar;

import exception.InvalidNumberInputException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private static final int[] weekdays = {4, 5, 6, 7, 11, 12, 13, 14, 18, 19, 20, 21, 25, 26, 27, 28};
    private static final int[] weekends = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30};
    private static final int[] stars = {3, 10, 17, 24, 25, 31};
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private List<Date> calendar = new ArrayList<>();

    public Calendar() {
        initCalendar();
    }

    private void initCalendar() {
        initWeekends();
        initWeekdays();
        initStar();
    }

    private void initWeekdays() {
        for (int weekday : weekdays) {
            calendar.add(new Date(weekday, false, false));
        }
    }

    private void initWeekends() {
        for (int weekend : weekends) {
            calendar.add(new Date(weekend, false, true));
        }
    }

    private void initStar() {
        for (int star : stars) {
            setDateHasStar(star);
        }

    }

    private void setDateHasStar(int star) {
        for (Date date : calendar) {
            if (date.getDate() == star) {
                date.setHasStar(true);
                break;
            }
        }
    }

    public List<Date> getCalendar() {
        return calendar;
    }

    public Date getDateInfo(int date) {
        validate(date);
        return calendar.get(date - 1);
    }

    private void validate(int date) {
        validateDateRange(date);
    }

    private void validateDateRange(int date) {
        if (!(MIN_DATE <= date && date <= MAX_DATE)) {
            throw new InvalidNumberInputException();
        }
    }

}
