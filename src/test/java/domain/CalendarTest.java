package domain;

import domain.calendar.Calendar;
import domain.calendar.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exception.InvalidNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalendarTest {

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new Calendar();
    }

    @DisplayName("유효 입력 테스트")
    @Test
    void getDateInfo_ValidInput() {
        // given
        int date = 10;

        // when
        Date result = calendar.getDateInfo(date);

        // then
        assertThat(result.getDate()).isEqualTo(date);
    }

    @DisplayName("유효하지 않은 입력 테스트")
    @Test
    void getDateInfo_InvalidInput() {
        // given
        int date = 32;

        // then
        assertThatThrownBy(() -> calendar.getDateInfo(date))
                .isInstanceOf(InvalidNumberInputException.class);
    }

    @DisplayName("별 정상 등록 여부 테스트")
    @Test
    void getDateInfo_StarDay() {
        // given
        int date = 3;

        // when
        Date result = calendar.getDateInfo(date);

        // then
        assertThat(result.isHasStar()).isTrue();
    }
}
