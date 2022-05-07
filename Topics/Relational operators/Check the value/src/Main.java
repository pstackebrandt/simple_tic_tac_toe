import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var number = scanner.nextInt();
        final var upperBorder = 10;
        final var isLess = number < upperBorder;
        System.out.println(isLess);
    }
}
