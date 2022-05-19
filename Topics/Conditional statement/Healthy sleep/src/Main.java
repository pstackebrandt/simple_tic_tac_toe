import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var a = scanner.nextInt();
        final var b = scanner.nextInt();
        final var h = scanner.nextInt();

        var result = "";
        if (h < a) {
            result = "Deficiency";
        } else if (h > b) {
            result = "Excess";
        } else {
            result = "Normal";
        }

        System.out.println(result);
    }
}