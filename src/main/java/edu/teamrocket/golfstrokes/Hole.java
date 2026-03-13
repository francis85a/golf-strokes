package edu.teamrocket.golfstrokes;

class Hole {
            
    private Byte number = 0;
    private Byte par = 0;

    Hole(Byte number, Byte par) {
    this.number = number;
    this.par = par;
    }

    Byte getNumber() {
        return this.number;
    }

    Byte getPar() {
        return this.par;

    }

    @Override
    public String toString() {
        return "Hole " + this.number + " (Par " + this.par + ")";
    }

}