package domain.calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private static final int[] weekdays = {4, 5, 6, 7, 11, 12, 13, 14, 18, 19, 20, 21, 25, 26, 27, 28};
    private static final int[] weekends = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30};
    private static final int[] stars = {3, 10, 17, 24, 25, 31};

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
}
