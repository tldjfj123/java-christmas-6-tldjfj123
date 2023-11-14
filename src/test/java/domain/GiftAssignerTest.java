package domain;

import domain.gift.Gift;
import domain.gift.GiftAssigner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GiftAssignerTest {

    @DisplayName("선물 조건 해당 테스트")
    @Test
    void assignGift_Gift() {
        // given
        int totalAmount = 120_000;

        // when
        Gift result = GiftAssigner.assignGift(totalAmount);

        // then
        assertThat(result.getName()).isEqualTo("샴페인");
    }

    @DisplayName("선물 조건 미해당 테스트")
    @Test
    void assignGift_None() {
        // given
        int totalAmount = 100_000;

        // when
        Gift result = GiftAssigner.assignGift(totalAmount);

        // then
        assertThat(result.getName()).isEqualTo("없음");
    }
}
