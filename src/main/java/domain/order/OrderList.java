package domain.order;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<Order> orderList = new ArrayList<>();

    public OrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
