import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        final int startSummand = scanner.nextInt();
        final int endSummand = scanner.nextInt();

        var sum = 0;
        //noinspection ConstantConditions
        if (false) {
            sum = new Summator().sumAllNumbersAndIncludeBorders(startSummand, endSummand);
        } else {
            sum = new Summator().sumAllNumbersAndIncludeBordersCalculation(startSummand, endSummand);
        }
        System.out.println(sum);
    }
}

class Summator {

    /**
     * Sum all values between {@param start} and {@param end} thereby include
     * {@param start} and {@param end}.
     * <p>
     * Algorithm: We add all values one after the other.
     */
    public int sumAllNumbersAndIncludeBorders(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Sum all values between {@param start} and {@param end} thereby include
     * {@param start} and {@param end}.
     *
     * Algorithm: I get the sum by calculation of the area of the geometrical figure.
     * If {@param start} and {@param end} are positive numbers bigger than 0 the figure
     * consists of a rectangular base and a rectangular triangle.
     */
    public int sumAllNumbersAndIncludeBordersCalculation(int start, int end) {
        final int width = end - start + 1;
        final int baseSum = width * start; // rectangle

        final int triangleHeight = end - start;
        int triangleSum = width * triangleHeight / 2;

        return baseSum + triangleSum;
    }
}