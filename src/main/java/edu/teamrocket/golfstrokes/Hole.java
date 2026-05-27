package edu.teamrocket.golfstrokes;

public class Hole {
            
    private Byte number;
    private Byte par;

    public Hole(Byte number, Byte par) {
        this.number = number;
        this.par = par;
    }

    public Byte getNumber() {
        return this.number;
    }

    public Byte getPar() {
        return this.par;
    }

    @Override
    public String toString() {
        return "Hole " + this.number + " (Par " + this.par + ")";
    }

}