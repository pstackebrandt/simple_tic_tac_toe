import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var first = scan.nextLine();
        var second = scan.nextLine();

        first = first.replace(" ", "");
        second = second.replace(" ", "");

        var areEqual = first.equals(second);

        System.out.println(areEqual);
    }
}
