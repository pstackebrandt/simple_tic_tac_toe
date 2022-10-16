package tictactoe.gamestate;

import tictactoe.Game;

/**
 * Holds information about the state of a game.
 */
public class GameData extends GameResultAbstract implements IGameData {

    public GameData(String stateLine, int cellsCount) {
        this.stateLine = stateLine;
        this.cellsCount = cellsCount;
    }

    /**
     * Describes each cell of the play ground. Contains no formatting.
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

    public String getPlayerXStateCharacter() {
        return "X";
    }

    public String getPlayerOStateCharacter() {
        return "O";
    }


    public String getEmptyCellStateCharacter() {
        return "_";
    }
}
