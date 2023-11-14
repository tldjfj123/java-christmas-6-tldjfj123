package controller;

import domain.order.OrderList;
import view.InputOrderView;

public class OrderController {
    public OrderList run() {
        InputOrderView inputOrderView = new InputOrderView();
        return inputOrderView.getValue();
    }
}
