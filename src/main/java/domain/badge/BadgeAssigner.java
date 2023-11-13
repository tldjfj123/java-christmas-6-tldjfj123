package domain.badge;

public class BadgeAssigner {
    private static final int STAR_THRESHOLD = 5_000;
    private static final int TREE_THRESHOLD = 10_000;
    private static final int SANTA_THRESHOLD = 20_000;

    public Badge assignBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA_THRESHOLD) {
            return new Badge("산타");
        }

        if (totalBenefitAmount >= TREE_THRESHOLD) {
            return new Badge("트리");
        }

        if (totalBenefitAmount >= STAR_THRESHOLD) {
            return new Badge("별");
        }

        return new Badge("없음");
    }
}
