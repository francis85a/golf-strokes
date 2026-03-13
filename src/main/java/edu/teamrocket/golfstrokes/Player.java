package edu.teamrocket.golfstrokes;

class Player {

    private final String initials;
    private Byte handicap;
    private Short score = 0;

    

    private Short points = 0;


    Player(String name, Byte strokes) {
        this.initials = name;
        this.handicap = strokes;
    }

    String getInitials() {
        return initials;
    }

    Byte getHandicap() {
        return handicap;
    }

    Short getScore() {
        return this.score;
    }
    
    Short getPoints() {
        return this.points;
    }

   

}