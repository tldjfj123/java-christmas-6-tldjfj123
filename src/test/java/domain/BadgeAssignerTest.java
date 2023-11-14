package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.badge.Badge;
import domain.badge.BadgeAssigner;
import domain.calendar.Date;
import domain.order.Order;
import domain.order.OrderList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeAssignerTest {

    private Date date;
    private OrderList orderList;

    @BeforeEach
    void setUp() {
        date = new Date(3, true, false); // 테스트를 위한 임의의 날짜 설정
        orderList = new OrderList(Arrays.asList(
                new Order("티본스테이크", 1),
                new Order("바비큐립", 1),
                new Order("초코케이크", 2),
                new Order("제로콜라", 1)
        ));
    }

    @DisplayName("산타 배지 테스트")
    @Test
    void assignBadge() {
        // when
        Badge result = BadgeAssigner.assignBadge(date, orderList);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("산타"); // 기대하는 배지 이름으로 변경
    }
}

