package edu.teamrocket.golfstrokes;

public class ComputeCard {
    private ScoreCard scoreCard;
    private GolfPlay golfPlay;

    public ComputeCard(ScoreCard scoreCard, GolfPlay golfPlay) {
        this.scoreCard = scoreCard;
        this.golfPlay = golfPlay;
    }

    public void compute() {
        this.golfPlay.scoring(this.scoreCard);
    }
}
