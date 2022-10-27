package tictactoe;

import junit.framework.TestCase;

public class AskMoveTest extends TestCase {

    public void should_accept_correct_values_and_return_point() {
        Game game = new Game();
        var actual = game.askMove(Player.X);
        assertEquals(actual.x, 2);
        assertEquals(actual.y, 1);
    }
}