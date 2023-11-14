package domain;

import domain.order.Order;
import domain.order.OrderAmountCalculator;
import domain.order.OrderList;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderAmountCalculatorTest {

    private OrderAmountCalculator orderAmountCalculator;

    @BeforeEach
    void setUp() {
        List<Order> tmp = new ArrayList<>();
        tmp.add(new Order("양송이수프", 2));
        tmp.add(new Order("바비큐립", 5));
        OrderList orderList = new OrderList(tmp);

        orderAmountCalculator = new OrderAmountCalculator(orderList);
    }

    @DisplayName("주문 합산 금액 테스트")
    @Test
    void calculateOrderAmountBeforeDiscount() {
        // given
        int expectedAmount = 282_000;

        // when
        int result = orderAmountCalculator.getOrderAmountBeforeDiscount();

        // then
        assertThat(result).isEqualTo(expectedAmount);
    }
}
