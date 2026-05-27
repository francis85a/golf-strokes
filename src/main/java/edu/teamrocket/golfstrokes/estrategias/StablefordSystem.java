package edu.teamrocket.golfstrokes.estrategias;

public enum StablefordSystem {
    DOUBLE_BOGEY(-3),
    BOGEY(-1),
    PAR(0),
    BIRDIE(2),
    EAGLE(5),
    ALBATROSS(8);

    private final int points;

    StablefordSystem(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public static int getPointsForDiff(int diff) {
        return switch (diff) {
            case 1 -> BOGEY.points;
            case 0 -> PAR.points;
            case -1 -> BIRDIE.points;
            case -2 -> EAGLE.points;
            default -> diff >= 2 ? DOUBLE_BOGEY.points : ALBATROSS.points;
        };
    }
}
