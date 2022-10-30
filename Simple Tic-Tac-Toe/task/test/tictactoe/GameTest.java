package tictactoe;

import junit.framework.TestCase;
import tictactoe.gamestate.GameData;

import java.awt.*;
import java.util.Scanner;

public class GameTest extends TestCase {

    public static class AskMoveTest extends TestCase {
        public void test_should_accept_correct_values_and_return_point() {
            final var gameData = new GameData("_________");
            final var game = new Game(gameData);

            final var scanner = new Scanner("2 3"); // col row Lesson description demands input order 'column row'.
            final var actual = game.askMove(Player.X, scanner);
            // internally we use order of 'row, column'
            assertEquals(actual.x, 3); // row
            assertEquals(actual.y, 2); // col
        }
    }

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

    public static class IsCellFreeTest extends TestCase {
        public void testShouldValidateFreeCell() {
            var actual = new Game().isCellFree(3, 2, "XO____X_O");
            assertTrue(actual);
        }

        public void testShouldInvalidateUsedCell() {
            var actual = new Game().isCellFree(3, 2, "XO____XOO");
            assertFalse(actual);
        }
    }

    public static class GetNumberFromConsoleTest extends TestCase {
        public void testShouldExtractNumber() {
            final var scanner = new Scanner("2 3");
            final var actual = new Game().getNumberFromConsole(scanner);
            assertEquals("Should return first number of input.", 2, (int) actual);
        }

        public void testShouldInvalidateStringInput() {
            final var scanner = new Scanner("ab cd");
            final var actual = new Game().getNumberFromConsole(scanner);
            assertNull("Should return null because input was string instead of number.", actual);
        }
    }

    public static class IsGameStateLineLengthValidTest extends TestCase {
        public void testShouldValidateGameStateWithCorrectLength() {
            final var actual = new Game().isGameStateLineLengthValid("_________");
            assertTrue("Should return true because length of game state is ok.", actual);
        }

        public void testShouldInvalidateGameStateWhichIsTooShort() {
            final var actual = new Game().isGameStateLineLengthValid("________"); // 8 chars
            assertFalse("Should return false because game state is too short.", actual);
        }
    }
}