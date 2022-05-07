import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var number = scanner.nextInt();
        final var isInRange = number > 0 && number < 10;
        System.out.println(isInRange);
    }
}