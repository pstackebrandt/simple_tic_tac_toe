package tictactoe.gamestate;

import java.util.ArrayList;

public interface IGameResult {
    GameStateCategory category = GameStateCategory.Unknown;
    ArrayList<GameStateError> errors = new ArrayList<>();
}
