package tictactoe.gamestate;

import java.util.ArrayList;

public interface IGameResult {
    GameStateCategory getGameStateCategory();
    void SetGameStateCategory(GameStateCategory category);
    ArrayList<GameStateError> GetErrors();
    void AddError(GameStateError error);
}

