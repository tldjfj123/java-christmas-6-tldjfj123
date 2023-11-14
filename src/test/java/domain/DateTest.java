package domain;

import domain.calendar.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import exception.InvalidNumberInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateTest {

    @DisplayName("유효 날짜 입력 테스트")
    @Test
    void createDate_ValidInput() {
        // given
        int date = 10;
        boolean hasStar = true;
        boolean isWeekend = false;

        // when
        Date result = new Date(date, hasStar, isWeekend);

        // then
        assertThat(result.getDate()).isEqualTo(date);
        assertThat(result.isHasStar()).isEqualTo(hasStar);
        assertThat(result.isWeekend()).isEqualTo(isWeekend);
    }

    @DisplayName("유효하지 않은 날짜 입력 테스트")
    @Test
    void createDate_InvalidInput() {
        // given
        int date = 32;
        boolean hasStar = true;
        boolean isWeekend = false;

        // then
        assertThatThrownBy(() -> new Date(date, hasStar, isWeekend))
                .isInstanceOf(InvalidNumberInputException.class);
    }

    @DisplayName("정렬을 위한 compareTo 메소드 테스트")
    @Test
    void testCompareTo() {
        // given
        Date date1 = new Date(10, true, false);
        Date date2 = new Date(20, false, true);

        // when
        int result = date1.compareTo(date2);

        // then
        assertThat(result).isNegative();
    }
}
