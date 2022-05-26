import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        var sum = 0;

        while (true) {
            var summand = scanner.nextInt();
            if (summand == 0) break;
            sum += summand;
        }

        System.out.println(sum);
    }
}