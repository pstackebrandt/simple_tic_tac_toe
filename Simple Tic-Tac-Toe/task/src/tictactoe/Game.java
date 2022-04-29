package tictactoe;

import tictactoe.gamestate.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Optional.empty;

/**
 * Tic tac toe game.
 * Rows and columns will be used dynamically to allow a game with
 * different playground dimensions.
 */
public class Game {
    final int playGroundRows = 3;
    final int playGroundColumns = 3;

    final private PlayGround playGround;

    // final static char[] ValidStateChars = {'O', 'X', '_'}; // todo decide which const to use
    final static String ValidStateCharsString = "OX_";  // todo decide which const to use, rename
    private final IGameData gameData;

    /**
     * @param gameStateLine Describes the game state. Example: "O_OXXO_XX"
     */
    public Game(String gameStateLine) {
        this.gameData = new GameData(
                cleanGameStateLine(gameStateLine),
                getCellsCount());

        this.playGround = new PlayGround(this.gameData.getGameStateSquare());
    }

    /**
     * Manage the game.
     */
    public void run() {

    }


    /**
     * Get count of all cells of this game.
     *
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

    private GameData categorizeGameState(String state, int fieldCount) {

        var result = new GameData(state, fieldCount);
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
        System.out.println(this.gameData.getGameStateLine());
    }

    public void printPlayGround() {
        playGround.printPlayGround();
    }

    /**
     * Print result of the game, e.g. winner, stalemate, erroneous state
     */
    public void printGameResult() {
        IGameResult gameResult = getGameResult(this.gameData);

        // check game results
        var stateCategory = gameResult.getGameStateCategory();
        switch (stateCategory) {
            case XWins:
                System.out.println("X wins");
                break;
            case OWins:
                System.out.println("O wins");
                break;
            case Draw:
                System.out.println("Draw");
                break;
            case NotFinished:
                System.out.println("Game not finished");
                break;
            case Impossible:
                System.out.println("Impossible");
                break;
            case Unknown:
                System.out.println("Error: Game state shouldn't be Unknown");
                break;
            default:
                System.out.println("Error: Unexpected game state category");
        }
    }

    /**
     * Get result of the game, e.g. Who wins, stalemate, error of current state.
     *
     * @param gameState
     * @return
     */
    private IGameResult getGameResult(final IGameState gameState) {
        Optional<IGameResult> result;
        // checkCountOfCells // todo later?

        // find invalid states of cell count
        result = invalidatePlayerCellsCount(gameState.getGameStateLine());
        if (result.isPresent()) return result.get();

        // Check win state of game
        result = getWinState(gameState); //x, o, draw, GameNotFinished, erroneous state
        if (result.isPresent()) return result.get();

        return new GameResult(GameStateCategory.Unknown); // is error
    }

    /**
     * Return information about winner, stalemate, game end without winner, erroneous state.
     *
     * @param gameState
     * @return GameResult.
     */
    // todo We don't seem to need an Optional. Remove!
    private Optional<IGameResult> getWinState(IGameState gameState) {
        var gameStateError = checkPlayerCellsCountDifference(gameState);
        if (gameStateError.isPresent()) {
            return Optional.of(new GameResult(GameStateCategory.Impossible,
                    gameStateError.get()
            ));
        }

        // calc winners
        int xWinsCount = getWinLinesCount(gameState, Player.X);
        int oWinsCount = getWinLinesCount(gameState, Player.O);

        if (xWinsCount + oWinsCount > 1) {
            return Optional.of(new GameResult(GameStateCategory.Impossible,
                    new GameStateError(GameStateErrorType.TooManyWinLines,
                            "Too many win lines"))
            );
        }

        if (xWinsCount == 1) {
            return Optional.of(new GameResult(GameStateCategory.XWins));
        }

        if (oWinsCount == 1) {
            return Optional.of(new GameResult(GameStateCategory.OWins));
        }

        final var stateLine = gameState.getGameStateLine();

        // calc ongoing game
        if (!stateLine.contains("_")) {
            return Optional.of(new GameResult(GameStateCategory.Draw));
        } else {
            return Optional.of(new GameResult(GameStateCategory.NotFinished));
        }
    }

    /**
     * Tells how many win lines player got.
     *
     * @return Count of win lines.
     */
    private int getWinLinesCount(IGameState gameState, Player player) {
        var linesCount = new AtomicInteger();

        final String cellChar = player.equals(Player.X) ? gameState.getPlayerXStateCharacter()
                : gameState.getPlayerOStateCharacter();

        final var workLine = gameState.getGameStateLine().replaceAll(cellChar, "#");

        var winPatterns = new ArrayList<String>();
        winPatterns.add("...###..."); // horizontal lines
        winPatterns.add("###......");
        winPatterns.add("......###");
        winPatterns.add("#..#..#.."); // vertical lines
        winPatterns.add(".#..#..#.");
        winPatterns.add("..#..#..#");
        winPatterns.add("#...#...#"); // diagonal lines
        winPatterns.add("..#.#.#..");

        winPatterns.forEach(pattern -> {
            if (workLine.matches(pattern)) {
                linesCount.set(linesCount.get() + 1);
            }
        });

        return linesCount.get();
    }

    /**
     * Tell whether cells count of the player is wrong.
     *
     * @return empty if no error found
     */
    private Optional<IGameStateError> checkPlayerCellsCountDifference(IGameState gameState) {
        int xCells = countPlayerCells(Player.X, gameState.getGameStateLine());
        int oCells = countPlayerCells(Player.O, gameState.getGameStateLine());

        if (Math.abs(xCells - oCells) > 1) {
            GameStateError error;
            if (xCells > oCells) {
                error = new GameStateError(GameStateErrorType.TOO_MANY_X_CELLS,
                        "Too many x cells");
            } else {
                error = new GameStateError(GameStateErrorType.TOO_MANY_O_CELLS,
                        "Too many o cells");
            }
            return Optional.of(error);
        }

        return Optional.empty();
    }

    /**
     * Checks whether cells of each player have incorrect count.
     *
     * @return Optional.Empty: no error in relation to cells found, GameResult: Cell count is wrong.
     * ({@link GameStateCategory} is additionally set to GameStateCategory.Impossible.)
     */
    private Optional<IGameResult> invalidatePlayerCellsCount(String stateLine) {
        int xCellCount = Game.countPlayerCells(Player.X, stateLine);
        int oCellCount = Game.countPlayerCells(Player.O, stateLine);

        // Wrong player cells difference
        if (Math.abs(xCellCount - oCellCount) > 1) {
            return Optional.of(new GameResult(GameStateCategory.Impossible));
        }
        return empty();
    }

    /**
     * Get count of all cells of a player.
     */
    protected static int countPlayerCells(Player player, String gameStateLine) {
        final var characters = Arrays.stream(gameStateLine.split(""));
        return (int) characters.filter(c -> c.equalsIgnoreCase(player.name())).count();
    }
}
