import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var squirrels = scanner.nextInt();
        var nuts = scanner.nextInt();
        
        var rest = nuts % squirrels;
        System.out.println(rest);
    }
}
