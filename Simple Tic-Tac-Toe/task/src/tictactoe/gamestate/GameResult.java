package tictactoe.gamestate;

import java.util.ArrayList;

/**
 * Describes result of a game (e.g. winner or no win possible because data error).
 */
public class GameResult extends GameResultAbstract {
    public GameResult(GameStateCategory category){
        this.category = category;
    }
}
