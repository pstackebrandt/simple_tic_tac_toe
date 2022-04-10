package tictactoe.gamestate;

import tictactoe.Game;

import java.util.ArrayList;

/**
 * Holds information about the state of a game.
 */
public class GameState implements IGameResult {

    public GameState(String stateLine, int cellsCount) {
        this.stateLine = stateLine;
        this.cellsCount = cellsCount;
    }

    /**
     * Describes each cell of the play ground. Contains not formatting.
     */
    private final String stateLine;
    private final int cellsCount;

    public GameStateCategory category = GameStateCategory.Unknown;
    public final ArrayList<GameStateError> errors = new ArrayList<>();

    public int getCellsCount() {
        return cellsCount;
    }

    public String getGameStateLine() {
        return stateLine;
    }

    public char[][] getGameStateSquare() {
        return Game.getGameStateSquare(this.stateLine, getCellsCount());
    }
}
