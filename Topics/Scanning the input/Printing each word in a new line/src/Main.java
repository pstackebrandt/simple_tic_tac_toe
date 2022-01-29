import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        final var wordCount = 5;
        for (var i = 0; i < wordCount; i++) {
            System.out.println(scanner.next());
        }
    }
}
