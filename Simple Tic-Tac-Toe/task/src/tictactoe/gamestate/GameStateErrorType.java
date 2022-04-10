package tictactoe.gamestate;

/**
 * Types of errors which can be found in a game state.
 */
public enum GameStateErrorType {
    TooManyXCells,
    TooManyYCells,
    TooManyXWinLines,
    TooManyYWinLines,
    WrongCellCount,
    WrongCharacter
}
