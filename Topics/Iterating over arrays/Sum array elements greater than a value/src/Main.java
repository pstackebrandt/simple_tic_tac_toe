import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var valuesCount = scanner.nextInt();
        final var values = new int[valuesCount];

        for (var i = 0; i < valuesCount; i++) {
            values[i] = scanner.nextInt();
        }

        final int border = scanner.nextInt();

        final var sum = sumValuesAboveBorder(values, border);

        System.out.println(sum);
    }

    private static int sumValuesAboveBorder(int[] values, int lowerBorder) {
        var sum = 0;
        for (var value : values) {
            if (value > lowerBorder) {
                sum += value;
            }
        }

        return sum;
    }
}