import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println(sumDigits(scanner.nextInt()));
    }

    private static int sumDigits(int number) {
        var sumOfDigits = 0;

        while (number > 9) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        sumOfDigits += number;

        return sumOfDigits;
    }
}