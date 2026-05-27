package edu.teamrocket.golfstrokes.estrategias;

import edu.teamrocket.golfstrokes.GolfPlay;
import edu.teamrocket.golfstrokes.ScoreCard;
import edu.teamrocket.golfstrokes.Player;

public class Stableford implements GolfPlay {

    @Override
    public void scoring(ScoreCard scoreCard) {
        for (Player player : scoreCard.getPlayers()) {
            byte[] course = scoreCard.getPlayerCourse(player);
            int totalPoints = 0;
            if (course != null) {
                for (int i = 0; i < course.length && i < scoreCard.getHoles().size(); i++) {
                    int par = scoreCard.getHoles().get(i).getPar();
                    int diff = course[i] - par;
                    totalPoints += StablefordSystem.getPointsForDiff(diff);
                }
            }
            player.setPoints(totalPoints);
        }
    }
}
