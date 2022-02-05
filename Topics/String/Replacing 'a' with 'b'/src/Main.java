import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var first = scanner.next();
        var result = first.replace("a", "b");
        System.out.println(result);
    }
}
