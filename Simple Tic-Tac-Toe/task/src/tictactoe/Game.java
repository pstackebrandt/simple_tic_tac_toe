package tictactoe;

import tictactoe.gamestate.GameState;
import tictactoe.gamestate.GameStateCategory;
import tictactoe.gamestate.GameStateError;

/**
 * Tic tac toe game.
 * Rows and columns will be used dynamically to allow a game with
 * different playground dimensions.
 */
public class Game {
    final int playGroundRows = 3;
    final int playGroundColumns = 3;

    private final char[][] gameState;
    final private PlayGround playGround;

    final static char[] ValidStateChars = {'O', 'X', '_'}; // todo decide which const to use
    final static String ValidStateCharsString = "OX_";  // todo decide which const to use, rename

    /**
     * @param state Describes the game state. Example: "O_OXXO_XX"
     */
    public Game(String state) {
        this.gameState = getGameState(state, playGroundRows * playGroundColumns);
        this.playGround = new PlayGround(gameState);
    }

    /**
     * Get valid game state.
     *
     * @param state may be invalid.
     * @return game state
     */
    // better CreateGameState ??
    public char[][] getGameState(String state, int fieldCount) {
        state = prepareState(state);
        var resultState = new char[3][3];

        boolean stateValid = Game.isValidGameState(state, fieldCount);

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
    protected static boolean isValidGameState(String state, int fieldCount) {
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
     * Prepare state for validity check.
     *
     * @param state
     * @return state which contains supported characters in uppercase only
     */
    protected static String prepareState(final String state) {
        return state.trim()
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

    public void printGameState() {
        System.out.println(stateToString(this.gameState));
    }

    public void printPlayGround() {
        playGround.printPlayGround();
    }

    public void printGameResult() {
        System.out.println("X wins");
    }
}
