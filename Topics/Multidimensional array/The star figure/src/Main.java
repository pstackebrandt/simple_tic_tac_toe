import java.util.Arrays;
import java.util.Scanner;
import figure.Figure;

class Main {
    public static void main(String[] args) {

        final int size = new Scanner(System.in).nextInt();
        var figure = new Figure(size);
        figure.show();
    }


}