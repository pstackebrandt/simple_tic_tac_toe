package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String stateInput;
        stateInput = scanner.next();
//        stateInput = "O_OXXO_XX";
//        System.out.println("Start game with state: " + stateInput);

        var game = new Game(stateInput);
        //game.printGameState();
        game.printPlayGround();
    }
}



