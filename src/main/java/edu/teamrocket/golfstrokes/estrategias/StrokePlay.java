package edu.teamrocket.golfstrokes.estrategias;

import edu.teamrocket.golfstrokes.GolfPlay;
import edu.teamrocket.golfstrokes.ScoreCard;
import edu.teamrocket.golfstrokes.Player;

public class StrokePlay implements GolfPlay {

    @Override
    public void scoring(ScoreCard scoreCard) {
        for (Player player : scoreCard.getPlayers()) {
            byte[] course = scoreCard.getPlayerCourse(player);
            int total = 0;
            if (course != null) {
                for (byte stroke : course) {
                    total += stroke;
                }
            }
            player.setScore(total);
        }
    }
}
