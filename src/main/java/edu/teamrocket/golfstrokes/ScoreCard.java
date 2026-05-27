package edu.teamrocket.golfstrokes;

import java.util.*;

public class ScoreCard {
    
    private Optional<Player> playerA = Optional.empty();
    private Optional<Player> playerB = Optional.empty();
    private Optional<Player> playerC = Optional.empty();
    private Optional<Player> playerD = Optional.empty();
    
    private final List<Hole> holes = new ArrayList<Hole>();
    
    private Course playersCourse;

    public ScoreCard() {};
    
    public void setPlayerA(Player player) {
        this.playerA = Optional.of(player);
    }

    public void setPlayerB(Player player) {
        this.playerB = Optional.of(player);
    }

    public void setPlayerC(Player player) {
        this.playerC = Optional.of(player);
    }

    public void setPlayerD(Player player) {
        this.playerD = Optional.of(player);
    }

    public void setPlayersCourse(Course playersCourse) {
        this.playersCourse = playersCourse;
    }

    public byte[] getPlayerCourse(Player player) {
        return this.playersCourse.getPlayerCourse(player);
    }
    
    public List<Player> getPlayers() {
        return Arrays.asList(playerA, playerB, playerC, playerD)
                .stream()
                .filter(player -> player.isPresent())
                .map(Optional::get)
                .toList();
    }

    public void addHoles(Byte[] holePar) {
        byte holeNumber = 1;
        for(Byte par : holePar) {
            this.holes.add(new Hole(holeNumber++, par));
        }
    }

    public List<Hole> getHoles() {
        return this.holes;
    }

    public byte getNumHoles() {
        return (byte) this.holes.size();
    }
}