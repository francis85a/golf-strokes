package edu.teamrocket.golfstrokes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Player playerMJ;

    @BeforeEach
    void setUp() {
        playerMJ = new Player("MJ", (byte) 0);
    }

    @Test
    void constructorCreatesPlayerObject() {
        assertNotNull(playerMJ);
    }

    @Test
    void constructorGetsNameAndStrokes() {
        assertEquals("MJ", playerMJ.getInitials());
        assertEquals((byte) 0, playerMJ.getHandicap());
    }

    @Test
    void getPointsReturnZeroByDefault() {
        assertEquals((short) 0, playerMJ.getPoints());
    }

    @Test
    void getShortScoreReturnZeroByDefault() {
        assertEquals((short) 0, playerMJ.getScore());
    }

}