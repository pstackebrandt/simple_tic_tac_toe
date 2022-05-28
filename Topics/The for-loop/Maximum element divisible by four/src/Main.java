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
    public static int getBiggestNumberDividableBy4(Scanner scanner, int numberCount) {
        int biggestDividableBy4 = 0;
        for (int i = 0; i < numberCount; i++) {
            int currentNumber = scanner.nextInt();
            if (currentNumber > biggestDividableBy4
                    && currentNumber % 4 == 0) {
                biggestDividableBy4 = currentNumber;
            }
        }
        return biggestDividableBy4;
    }
}