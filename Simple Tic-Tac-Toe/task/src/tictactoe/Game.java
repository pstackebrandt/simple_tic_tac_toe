package tictactoe;

import tictactoe.gamestate.GameState;
import tictactoe.gamestate.GameStateCategory;

/**
 * Tic tac toe game.
 * Rows and columns will be used dynamically to allow a game with
 * different playground dimensions.
 */
public class Game {
    final int playGroundRows = 3;
    final int playGroundColumns = 3;

    final private PlayGround playGround;

    final static char[] ValidStateChars = {'O', 'X', '_'}; // todo decide which const to use
    final static String ValidStateCharsString = "OX_";  // todo decide which const to use, rename
    private final GameState gameState;

    /**
     * @param gameStateLine Describes the game state. Example: "O_OXXO_XX"
     */
    public Game(String gameStateLine) {
        this.gameState = new GameState(
                cleanGameStateLine(gameStateLine),
                getCellsCount());

        this.playGround = new PlayGround(this.gameState.getGameStateSquare());
    }

    /**
     * Get count of all cells of this game.
     * @return cells count
     */
    private int getCellsCount() {
        return playGroundRows * playGroundColumns;
    }

    /**
     * Get game state as a 2 dimensional representation.
     *
     * @param state may be invalid.
     * @return game state
     */
    public static char[][] getGameStateSquare(String state, int fieldCount) {
        var resultState = new char[3][3];

        boolean stateValid = Game.isStateLineRepresentableAsSquare(state, fieldCount);

        if (!stateValid) {
            throw new IllegalArgumentException(String.format("Game state '%s' is invalid.", state));
        }

        var stateChars = state.toCharArray();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                resultState[row][col] = stateChars[row * 3 + col];
            }
        }

        return resultState;
    }

    /**
     * Returns whether state is valid for the game.
     * (Currently we don't check whether count of state chars of both players is valid.)
     *
     * @param state      to be checked.
     * @param fieldCount is expected count of fields of the play ground.
     */
    protected static boolean isStateLineRepresentableAsSquare(String state, int fieldCount) {
        if (state == null) return false;
        if (state.length() != fieldCount) return false;   // must contain 9 valid chars for a 3x3 play field

        // must contain only _, X, O (letter)
        for (String character : state.split("")) {
            if (!ValidStateCharsString.contains(character)) {
                return false;
            }
        }

        // todo ?? check whether count of state chars of both players is valid.

        return true;
    }

    private GameState categorizeGameState(String state, int fieldCount) {

        var result = new GameState(state, fieldCount);
        result.category = GameStateCategory.XWins;
        //result.errors.add(new GameStateError());

        return result;
    }

    /**
     * Prepare state line for validity check.
     *
     * @return state which contains supported characters in uppercase only
     */
    protected static String cleanGameStateLine(final String stateLine) {
        return stateLine.trim()
                .toUpperCase();
    }

    public String stateToString(char[][] state) {
        var result = new StringBuilder();

        for (int row = 0; row < playGroundRows; row++) {
            for (int col = 0; col < playGroundColumns; col++) {
                result.append(state[row][col]);
            }
        }

        return result.toString();
    }

    public void printGameStateSquare() {
        System.out.println(this.gameState.getGameStateLine());
    }

    public void printPlayGround() {
        playGround.printPlayGround();
    }

    public void printGameResult() {
        System.out.println("X wins");
    }
}
