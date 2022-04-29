package tictactoe.gamestate;

/**
 * Describes current state of a game. It is temporary state.
 * It will be changed or extended at every turn of game.
 */
public interface IGameState {
    String getGameStateLine();

    char[][] getGameStateSquare();

    /**
     * Get character which marks cells of player X in state.
     */
    String getPlayerXStateCharacter();

    /**
     * Get character which marks cells of player O in state.
     */
    String getPlayerOStateCharacter();

    /**
     * Get character which marks empty cells in state.
     */
    String getEmptyCellStateCharacter();
}
