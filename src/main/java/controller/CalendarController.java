package controller;

import domain.calendar.Calendar;
import domain.calendar.Date;
import view.InputDateView;

public class CalendarController {
    public Date run() {
        InputDateView inputDateView = new InputDateView();
        int inputDate = inputDateView.getValue();

        Calendar calendar = new Calendar();
        return calendar.getDateInfo(inputDate);
    }
}
