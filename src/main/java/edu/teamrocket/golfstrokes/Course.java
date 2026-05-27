package edu.teamrocket.golfstrokes;

import java.util.*;

public class Course {
    private final List<PlayerCourse> playersCourse;
    private final List<Hole> holes;

    public Course() {
        this.playersCourse = new ArrayList<>();
        this.holes = new ArrayList<>();
    }

    public void addPlayerCourse(Player player, Byte[] handicaps) {
        if (handicaps == null) return;
        byte[] arr = new byte[handicaps.length];
        for (int i = 0; i < handicaps.length; i++) {
            arr[i] = handicaps[i];
        }
        this.playersCourse.add(new PlayerCourse(player.getInitials(), arr));
    }

    public void addPlayerCourse(Player player, byte[] handicaps) {
        if (handicaps == null) return;
        this.playersCourse.add(new PlayerCourse(player.getInitials(), Arrays.copyOf(handicaps, handicaps.length)));
    }

    public byte[] getPlayerCourse(Player player) {
        for (PlayerCourse pc : this.playersCourse) {
            if (pc.initials.equals(player.getInitials())) return Arrays.copyOf(pc.course, pc.course.length);
        }
        return null;
    }

    private static class PlayerCourse {
        final String initials;
        final byte[] course;

        PlayerCourse(String initials, byte[] course) {
            this.initials = initials;
            this.course = course;
        }
    }

    public void addHole(Hole hole) {
        this.holes.add(hole);
    }

    public List<Hole> getHoles() {
        return this.holes;
    }

    public int getNumHoles() {
        return this.holes.size();
    }
}
