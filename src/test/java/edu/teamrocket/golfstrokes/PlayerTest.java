package edu.teamrocket.golfstrokes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void constructorCreatesPlayerObject() {
        Player playerMJ = new Player("MJ", (byte) 0);
        assertNotNull(playerMJ);
    }

    @Test
    void constructorGetsNameAndStrokes() {
        Player playerMJ = new Player("MJ", (byte) 0);
        assertEquals("MJ", playerMJ.getInitials());

        assertEquals((byte) 0, playerMJ.getHandicap());
    }


}