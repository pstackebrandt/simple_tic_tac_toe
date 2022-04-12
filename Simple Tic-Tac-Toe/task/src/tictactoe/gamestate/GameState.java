package tictactoe.gamestate;

import tictactoe.Game;

import java.util.ArrayList;

interface IGameState {
    String getGameStateLine();

    char[][] getGameStateSquare();
}

interface IGameSetup {
    int getCellsCount();

    int getPlayGroundRowsCount();

    int getPlayGroundColumnsCount();
}

/**
 * Holds information about the state of a game.
 */
public class GameState extends GameResultAbstract implements IGameState, IGameSetup {

    public GameState(String stateLine, int cellsCount) {
        this.stateLine = stateLine;
        this.cellsCount = cellsCount;
    }

    /**
     * Describes each cell of the play ground. Contains not formatting.
     */
    private final String stateLine;
    private final int cellsCount;

    public int getCellsCount() {
        return cellsCount;
    }

    public int getPlayGroundRowsCount() {
        return 3;
    }

    public int getPlayGroundColumnsCount() {
        return 3;
    }

    public String getGameStateLine() {
        return stateLine;
    }

    public char[][] getGameStateSquare() {
        return Game.getGameStateSquare(this.stateLine, getCellsCount());
    }

}
