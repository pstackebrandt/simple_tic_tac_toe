package tictactoe.gamestate;

import java.util.ArrayList;

abstract class GameResultAbstract implements IGameResult {
    public final ArrayList<IGameStateError> errors = new ArrayList<>();
    public GameStateCategory category = GameStateCategory.Unknown;

    public GameStateCategory getGameStateCategory() {
        return this.category;
    }

    /**
     * Change game state category. This category is like a summary
     * of the current game state. Someone who changes this, doesn't change
     * the state of the game but the evaluation of the game state.
     *
     * @param category New game state category.
     */
    // Should we always get the GameStateCategory on the fly? Without saving it?
    public void SetGameStateCategory(GameStateCategory category) {
        if (category != null) {
            this.category = category;
        }
    }

    public ArrayList<IGameStateError> GetErrors() {
        return errors;
    }

    public void AddError(IGameStateError error) {
        if (error != null) {
            this.errors.add(error);
        }
    }
}
