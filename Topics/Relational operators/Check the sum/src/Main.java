import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var a = scanner.nextInt();
        final var b = scanner.nextInt();
        final var c = scanner.nextInt();

        final var checkedValue = 20;
        final var anySumIs20 = a + b == checkedValue
                || b + c == checkedValue
                || a + c == checkedValue;

        System.out.println(anySumIs20);
    }
}