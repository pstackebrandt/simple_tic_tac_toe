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

            final var scanner = new Scanner("3 2"); // (row col)
            final var actual = game.askMove(Player.X, scanner);
            // internally we use order of 'row, column'
            assertEquals("x (row) should be as expected.", 2, actual.x); // row
            assertEquals("y (column) should be as expected.", 1, actual.y ); // col
        }
    }

    public static class GetInitialGameStateTest extends TestCase {
        public void test_should_accept_correct_values_and_return_game_state() {
            final var expected = "__XO_____";
            final var scanner = new Scanner("__XO_____");

            final var actual = new Game().getInitialGameState(scanner);

            assertEquals(actual, expected); // row
        }

        public void test_should_reject_line_with_wrong_char_count_and_return_game_state_of_correct_line() {
            final var expected = "__XO_____";
            final var scanner = new Scanner("__XO__\n__XO_____"); //first line is wrong, second ok

            final var actual = new Game().getInitialGameState(scanner);

            assertEquals(expected, actual); // row
        }

        public void test_should_reject_line_with_wrong_chars_and_return_game_state_of_correct_line() {
            final var expected = "__XO_____";
            final var scanner = new Scanner("__XO_1___\n__XO_____"); //first line is wrong, second ok

            final var actual = new Game().getInitialGameState(scanner);

            assertEquals(actual, expected); // row
        }
    }

    public static class IsCoordinateWithinBoundsTest extends TestCase {

        public void testShouldValidateCorrectPoint() {
            var actual = new Game().isCoordinateWithinBounds(new Point(1, 2));
            assertTrue(actual);
        }

        public void testShouldInvalidateXValueAsTooSmall() {
            var actual = new Game().isCoordinateWithinBounds(new Point(1, 3));
            assertFalse(actual);
        }

        public void testShouldInvalidateYValueAsTooSmall() {
            var actual = new Game().isCoordinateWithinBounds(new Point(0, -1));
            assertFalse(actual);
        }
    }

    public static class IsCellFreeTest extends TestCase {
        public void testShouldValidateFreeCell() {
            var actual = new Game().isCellFree(2, 1, "XO____X_O");
            assertTrue(actual);
        }

        public void testShouldTellThatCellIsTaken1() {
            var actual = new Game().isCellFree(2, 1, "XO____XOO");
            assertFalse(actual);
        }

        public void testShouldTellThatCellIsTaken2() {
            var actual = new Game().isCellFree(2, 1, "_XXOO_OX_");
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

    public static class IsGameStateConsistsOfValidCharsTest extends TestCase {
        public void testShouldValidateGameStateWithCorrectChars() {
            final var actual = new Game().isGameStateConsistsOfValidChars("_X__O______");
            assertTrue("Should return true because all chars allowed.", actual);
        }

        public void testShouldInvalidateGameStateUnexpectedChars() {
            final var actual = new Game().isGameStateConsistsOfValidChars("_y__10_XO_");
            assertFalse("Should return false because game state contains unexpected chars.", actual);
        }
    }

    public void testDummyTestForClassWithoutFurtherTests(){
        assertTrue(true);
    }
}