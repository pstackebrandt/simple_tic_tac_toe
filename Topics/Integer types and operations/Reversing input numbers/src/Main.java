import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var first = scanner.next();
        var res = scanner.next() + " " + first;
        System.out.println(res);
    }
}