import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var a = scanner.nextInt();
        var b = scanner.nextInt();
        var c = scanner.nextInt();

        var areAllDifferent = a != b && b != c && a != c;

        System.out.println(areAllDifferent);
    }
}