package domain;

import domain.menu.MenuItem;
import domain.menu.MenuRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exception.InvalidOrderInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {

    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        menuRepository = new MenuRepository();
    }

    @DisplayName("존재하는 메뉴 테스트")
    @Test
    void isExist_ValidInput() {
        // given
        String menuName = "타파스"; // 실제 메뉴 이름으로 변경해야 합니다.

        // when
        boolean result = menuRepository.isExist(menuName);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("존재하지 않는 메뉴 테스트")
    @Test
    void isExist_InvalidInput() {
        // given
        String menuName = "탕후루";

        // when
        boolean result = menuRepository.isExist(menuName);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("존재하는 메뉴 조회 테스트")
    @Test
    void findByName_ValidInput() {
        // given
        String menuName = "제로콜라";

        // when
        MenuItem result = menuRepository.findByName(menuName);

        // then
        assertThat(result.getName()).isEqualTo(menuName);
    }

    @DisplayName("존재하지 않는 메뉴 조회 테스트")
    @Test
    void findByName_InvalidInput() {
        // given
        String menuName = "마라탕";

        // then
        assertThatThrownBy(() -> menuRepository.findByName(menuName))
                .isInstanceOf(InvalidOrderInputException.class);
    }
}
