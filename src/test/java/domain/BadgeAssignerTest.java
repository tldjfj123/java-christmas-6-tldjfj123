package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.badge.Badge;
import domain.badge.BadgeAssigner;
import domain.order.OrderAmountCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeAssignerTest {

    @DisplayName("산타 등급 테스트")
    @Test
    void assignBadge_Santa() {
        // given
        int totalBenefitAmount = 20_000;

        // when
        Badge result = BadgeAssigner.assignBadge(totalBenefitAmount);

        // then
        assertThat(result.getName()).isEqualTo("산타");
    }

    @DisplayName("나무 등급 테스트")
    @Test
    void assignBadge_Tree() {
        // given
        int totalBenefitAmount = 10_000;

        // when
        Badge result = BadgeAssigner.assignBadge(totalBenefitAmount);

        // then
        assertThat(result.getName()).isEqualTo("나무");
    }

    @DisplayName("스타 등급 테스트")
    @Test
    void assignBadge_Star() {
        // given
        int totalBenefitAmount = 5_000;
        OrderAmountCalculator.setOrderAmountBeforeDiscount(10_000);

        // when
        Badge result = BadgeAssigner.assignBadge(totalBenefitAmount);

        // then
        assertThat(result.getName()).isEqualTo("별");
    }

    @DisplayName("없음 테스트")
    @Test
    void assignBadge_None() {
        // given
        int totalBenefitAmount = 1_000;

        // when
        Badge result = BadgeAssigner.assignBadge(totalBenefitAmount);

        // then
        assertThat(result.getName()).isEqualTo("없음");
    }
}
