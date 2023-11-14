package domain;

import domain.discount.DiscountCalculator;
import domain.order.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import domain.calendar.Date;
import domain.order.OrderList;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountCalculatorTest {

    private DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp() {
        Date date = new Date(8, false, true);

        List<Order> tmp = new ArrayList<>();
        tmp.add(new Order("양송이수프", 2));
        tmp.add(new Order("바비큐립", 5));
        OrderList orderList = new OrderList(tmp);
        discountCalculator = new DiscountCalculator(date, orderList);
    }

    @DisplayName("계산 테스트")
    @Test
    void calculateDiscounts() {
        // given
        int expectedDiscountAmount = 11_815;

        // when
        int result = discountCalculator.getDiscountAmount();

        // then
        assertThat(result).isEqualTo(expectedDiscountAmount);
    }
}
