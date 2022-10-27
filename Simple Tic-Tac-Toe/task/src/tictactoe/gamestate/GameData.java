package tictactoe.gamestate;

import tictactoe.Game;

/**
 * Holds information about the state of a game.
 */
public class GameData extends GameResultAbstract implements IGameData {

    public GameData(String stateLine) {
        this.stateLine = stateLine;
    }

    /**
     * Describes each cell of the play ground. Contains no formatting.
     */
    private final String stateLine;

    public int getCellsCount() {
        return stateLine.length();
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

    /**
     * Add a valid move.
     * Throws an error if the move isn't valid.
     *
     * @param row
     * @param col
     */
    @Override
    public void addMove(int row, int col) {

    }
}
