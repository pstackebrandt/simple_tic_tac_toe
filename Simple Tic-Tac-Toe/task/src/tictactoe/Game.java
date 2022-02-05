package tictactoe;

public class Game {
    int playGroundRows = 3;
    int playGroundColumns = 3;

    private char[][] gameState = new char[3][3];

    public Game(String state) {
        this.gameState = Game.getGameState(state);
    }

    public static char[][] getGameState(String state) {
        state = cleanState(state);
        var resultState = new char[3][3];

        boolean stateValid = Game.isValidGameState(state);

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

    protected static boolean isValidGameState(String state) {
        // todo check content
        // must contain only _ O (letter) X
        // must contain 9 chars

        return true;
    }

    protected static String cleanState(String state) {
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
}
