import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var number = scanner.nextLong();

        int iteration = Factorial.getIterationOfFirstBiggerValue(number);
        System.out.println(iteration);
    }
}

/**
 * Contains code for work with factorial (n!).
 */
class Factorial {
    /**
     * Get iteration (n) for first factorial value which is bigger than {@param number}.
     *
     * @return value n of "n!"
     */
    public static int getIterationOfFirstBiggerValue(long number) {
        var factorial = 1L; // Product
        var iteration = 1; // Count of multiplications

        while (number >= factorial) {
            iteration++;
            factorial = Factorial.getNextFactorial(factorial, iteration);
        }
        return iteration;
    }

    /**
     * Get next factorial "n!" from {@param factorial} (n-1)! and {@param factor} n
     *
     * @param factorial current factorial
     * @param factor    factor for next factorial
     */
    public static long getNextFactorial(long factorial, int factor) {
        return factorial * factor;
    }
}