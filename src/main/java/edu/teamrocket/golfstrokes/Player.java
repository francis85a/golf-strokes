package edu.teamrocket.golfstrokes;

public class Player {

    private final String initials;
    private Byte handicap;
    private Short score = 0;
    private Short points = 0;

    public Player(String name, Byte strokes) {
        this.initials = name;
        this.handicap = strokes;
    }

    public String getInitials() {
        return initials;
    }

    public Byte getHandicap() {
        return handicap;
    }

    public Short getScore() {
        return this.score;
    }
    
    public Short getPoints() {
        return this.points;
    }

    public void setScore(int score) {
        this.score = (short) score;
    }

    public void setPoints(int points) {
        this.points = (short) points;
    }

    @Override
    public String toString() {
        return this.initials + " - Score: " + this.score + ", Points: " + this.points;
    }
}