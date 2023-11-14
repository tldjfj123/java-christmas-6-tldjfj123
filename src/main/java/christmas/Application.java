package christmas;

import controller.CalendarController;
import controller.OrderController;
import controller.PreviewController;
import domain.calendar.Date;
import domain.order.OrderList;
import view.WelcomeView;

public class Application {
    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.welcome();

        CalendarController calendarController = new CalendarController();
        Date date = calendarController.run();

        OrderController orderController = new OrderController();
        OrderList orderList = orderController.run();

        PreviewController previewController = new PreviewController();
        previewController.run(date, orderList);
    }
}
