import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        final var lowerBorder = scanner.nextInt();
        final var upperBorder = scanner.nextInt();
        final var divisor = scanner.nextInt();

        final int divisibleNumbers =
                Checker.countDivisibleNumbers(lowerBorder, upperBorder, divisor);

        System.out.println(divisibleNumbers);
    }
}

class Checker {
    public static int countDivisibleNumbers(int lowerBorder,
                                            int upperBorder,
                                            int divisor) {
        int count = 0;
        for (int i = lowerBorder; i <= upperBorder; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }

        return count;
    }
}