package tictactoe.gamestate;

import java.util.ArrayList;

/**
 * Holds information about the state of a game.
 */
public class GameState implements IGameResult {

    public GameState(String state, int cellsCount) {
        this.state = state;
        this.cellsCount = cellsCount;
    }

    /**
     * Describes each cell of the play ground. Contains not formatting.
     */
    private final String state;
    private final int cellsCount;

    public GameStateCategory category = GameStateCategory.Unknown;
    public final ArrayList<GameStateError> errors = new ArrayList<>();

    public int getCellsCount() {
        return cellsCount;
    }

    public String getState() {
        return state;
    }
}
