package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String gameStateInput;
        gameStateInput = scanner.next();
//        System.out.println("Start game with state: " + stateInput);

        var game = new Game(gameStateInput);
        //game.printGameState();
        game.printPlayGround();
        game.printGameResult();
    }
}



