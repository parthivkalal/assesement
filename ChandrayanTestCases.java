package ChandrayanTests;
import Chandrayan.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class ChandrayanPositionDirectionTest {

    @Test
    void testMoveForward() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'f'});
        assertEquals("(0, 1, 0)", chandra.getCurrentPosition());
    }

    @Test
    void testMoveBackward() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'b'});
        assertEquals("(0, -1, 0)", chandra.getCurrentPosition());
    }

    @Test
    void testTurnLeft() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'l'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());
        assertEquals('N', chandra.getDirection());
    }

    @Test
    void testTurnRight() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'r'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());
        assertEquals('E', chandra.getDirection());
    }

    @Test
    void testTurnUp() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'u'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());
        assertEquals('U', chandra.getDirection());
    }

    @Test
    void testTurnDown() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'d'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());
        assertEquals('D', chandra.getDirection());
    }

    @Test
    void testMultipleCommands() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');
        chandra.executeCommands(new char[]{'f', 'r', 'u', 'l', 'f', 'b', 'd'});
        assertEquals("(0, 1, 0)", chandra.getCurrentPosition());
        assertEquals('D', chandra.getDirection());
    }

    @Test
    void testEdgeCases() {
        ChandrayanPositionDirection chandra = new ChandrayanPositionDirection(0, 0, 0, 'N');

        // Test moving and turning
        chandra.executeCommands(new char[]{'f', 'b', 'l', 'r', 'u', 'd'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());

        // Test rotating while facing up or down
        chandra = new ChandrayanPositionDirection(0, 0, 0, 'U');
        chandra.executeCommands(new char[]{'l', 'r'});
        assertEquals("(0, 0, 0)", chandra.getCurrentPosition());
        assertEquals('U', chandra.getDirection());
    }
}
