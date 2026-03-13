package edu.teamrocket.golfstrokes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HoleTest {

    private Hole hole;

    @BeforeEach
    void setUp() {
        hole = new Hole((byte) 1, (byte) 4); // Configuración del objeto Hole
    }

    @Test
    void testHoleCreation() {
        assertNotNull(hole);
    }

    @Test
    void testGetNumber() {
        assertEquals((byte) 1, hole.getNumber(), "El número del hoyo debe ser 1");
    }

    @Test
    void testGetPar() {
        assertEquals((byte) 4, hole.getPar(), "El par del hoyo debe ser 4");
    }
}