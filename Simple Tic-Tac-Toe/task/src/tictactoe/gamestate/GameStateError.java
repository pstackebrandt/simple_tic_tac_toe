package tictactoe.gamestate;

/**
 * Describes error of a game state.
 */
public class GameStateError implements IGameStateError {
    private GameStateErrorType type;
    private String errorMessage;

    public GameStateError(GameStateErrorType type, String errorMessage) {
        this.type = type;
        this.errorMessage = errorMessage;
    }
}
