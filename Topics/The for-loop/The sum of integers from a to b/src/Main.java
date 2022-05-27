import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        final int startSummand = scanner.nextInt();
        final int endSummand = scanner.nextInt();

        var sum = new Summator().sumAllNumbersAndIncludeBorders(startSummand, endSummand);

        System.out.println(sum);
    }
}

class Summator {
    public int sumAllNumbersAndIncludeBorders(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}