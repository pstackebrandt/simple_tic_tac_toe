package tictactoe.gamestate;

/**
 * Describes result of a game (e.g. winner or no win possible because data error).
 */
public class GameResult extends GameResultAbstract {
    public GameResult(GameStateCategory category) {
        this.category = category;
    }

    public GameResult(GameStateCategory category, IGameStateError error) {
        this.category = category;
        this.errors.add(error);
    }
}
