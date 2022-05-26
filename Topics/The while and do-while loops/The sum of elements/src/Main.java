import java.util.Scanner;

class Main {
    public static final int STOP_NUMBER = 0;

    public static void main(String[] args) {

        final var scanner = new Scanner(System.in);
        var sum = 0;

        while (true) {
            var summand = scanner.nextInt();
            if (summand == STOP_NUMBER) {
                break;
            }
            sum += summand;
        }

        System.out.println(sum);
    }
}