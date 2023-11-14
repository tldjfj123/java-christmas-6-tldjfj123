package controller;

import domain.menu.MenuRepository;
import domain.order.OrderList;
import domain.order.OrderProcessor;
import view.InputOrderView;

public class OrderController {
    public OrderList run() {
        InputOrderView inputOrderView = new InputOrderView();
        return inputOrderView.getValue();
    }
}
