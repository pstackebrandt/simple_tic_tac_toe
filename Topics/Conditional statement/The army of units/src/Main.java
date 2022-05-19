import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final var units = scanner.nextInt();
        var army = "";
        if (units < 1) {
            army = "no army";
        } else if (units <= 19) {
            army = "pack";
        } else if (units <= 249) {
            army = "throng";
        } else if (units <= 999) {
            army = "zounds";
        } else {
            army = "legion";
        }

        System.out.println(army);
    }
}
