package domain.badge;

public class BadgeAssigner {
    private static final int STAR_THRESHOLD = 5_000;
    private static final int TREE_THRESHOLD = 10_000;
    private static final int SANTA_THRESHOLD = 20_000;
    private static final String SANTA = "산타";
    private static final String TREE = "나무";
    private static final String STAR = "별";
    private static final String NONE = "없음";


    public Badge assignBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= SANTA_THRESHOLD) {
            return new Badge(SANTA);
        }

        if (totalBenefitAmount >= TREE_THRESHOLD) {
            return new Badge(TREE);
        }

        if (totalBenefitAmount >= STAR_THRESHOLD) {
            return new Badge(STAR);
        }

        return new Badge(NONE);
    }
}
