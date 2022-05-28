import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        final int numberCount = scanner.nextInt();

        int biggestDividableBy4 = Checker.getBiggestNumberDividableBy4(scanner, numberCount);

        System.out.println(biggestDividableBy4);
    }


}

class Checker {
    public static int getBiggestNumberDividableBy4(Scanner source, int numberCount) {
        int biggestDividableBy4 = 0;
        for (int i = 0; i < numberCount; i++) {
            int currentNumber = source.nextInt();
            if (isFirstNumberBiggerAndDividableBy4(currentNumber, biggestDividableBy4)) {
                biggestDividableBy4 = currentNumber;
            }
        }
        return biggestDividableBy4;
    }

    private static boolean isFirstNumberBiggerAndDividableBy4(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber
                && firstNumber % 4 == 0;
    }
}