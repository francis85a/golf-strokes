package edu.teamrocket.golfstrokes.estrategias;

import edu.teamrocket.golfstrokes.GolfPlay;

public class Teams implements GolfPlay{
    
    @Override

    public void scoring(ScoreCard scoreCard) {
        scoreCard.getPlayers().forEach(player ->
            player.setScore(
            scoreCard.getPlayerCourse(player)
                .stream()
                .mapToInt(Integer::intValue)
                .sum()
            )
        );
            
    }
};
