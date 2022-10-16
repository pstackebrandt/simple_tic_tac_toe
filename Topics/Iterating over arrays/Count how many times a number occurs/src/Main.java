import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var input = getValuesAndNumberToCount();

        final var numberCount = countNumberOccurrence(
                input.values,
                input.numberToCount);

        System.out.println(numberCount);
    }

    private static ValuesAndNumberToCount getValuesAndNumberToCount() {
        final var scanner = new Scanner(System.in);
        final var valuesCount = scanner.nextInt();
        final var values = new int[valuesCount];

        var valuesRead = 0;
        while (valuesRead < valuesCount) {
            values[valuesRead] = scanner.nextInt();
            valuesRead++;
        }

        final var numberToCount = scanner.nextInt();

        return new ValuesAndNumberToCount(values, numberToCount);
    }

    private static int countNumberOccurrence(int[] values, int numberToCount) {
        var count = 0;
        for (int i : values) {
            if (i == numberToCount) {
                count++;
            }
        }
        return count;
    }
}

class ValuesAndNumberToCount {
    final public int[] values;
    final public int numberToCount;

    ValuesAndNumberToCount(int[] values, int numberToCount) {
        this.values = values;
        this.numberToCount = numberToCount;
    }
}