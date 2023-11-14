package domain;

import domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exception.InvalidNumberInputException;
import exception.InvalidOrderInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {

    @DisplayName("유효 주문 입력 테스트")
    @Test
    void createOrder_ValidInput() {
        // given
        String menuName = "샴페인";
        int quantity = 1;

        // when
        Order result = new Order(menuName, quantity);

        // then
        assertThat(result.getMenuName()).isEqualTo(menuName);
        assertThat(result.getQuantity()).isEqualTo(quantity);
    }

    @DisplayName("유효하지 않은 주문이름 입력 테스트")
    @Test
    void createOrder_InvalidMenuName() {
        // given
        String menuName = "탕후루";
        int quantity = 1;

        // then
        assertThatThrownBy(() -> new Order(menuName, quantity))
                .isInstanceOf(InvalidOrderInputException.class);
    }

    @DisplayName("유효하지 않은 주문 양 입력 테스트")
    @Test
    void createOrder_InvalidQuantity() {
        // given
        String menuName = "초코케이크"; // 실제 메뉴 이름으로 변경해야 합니다.
        int quantity = 0;

        // then
        assertThatThrownBy(() -> new Order(menuName, quantity))
                .isInstanceOf(InvalidNumberInputException.class);
    }
}
