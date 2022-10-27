package tictactoe;

import junit.framework.TestCase;

import java.awt.*;

public class GameTest extends TestCase {

    public static class IsCoordinateWithinBoundsTest extends TestCase {

        public void testShouldValidateCorrectPoint() {
            var actual = new Game().isCoordinateWithinBounds(new Point(1, 2));
            assertTrue(actual);
        }

        public void testShouldInvalidateXValueAsTooSmall() {
            var actual = new Game().isCoordinateWithinBounds(new Point(0, 2));
            assertFalse(actual);
        }

        public void testShouldInvalidateYValueAsTooSmall() {
            var actual = new Game().isCoordinateWithinBounds(new Point(1, 0));
            assertFalse(actual);
        }
    }

    public void testName() {

    }
}