package tictactoe.gamestate;

import java.util.ArrayList;

/**
 * Describes result of a game.
 */
public interface IGameResult {
    GameStateCategory getGameStateCategory();

    void SetGameStateCategory(GameStateCategory category);

    ArrayList<IGameStateError> GetErrors();

    void AddError(IGameStateError error);
}

