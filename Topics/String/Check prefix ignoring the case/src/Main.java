import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var word = scan.next();
        word = word.toLowerCase();
        var startsWithJ = word.charAt(0) == 'j';
        System.out.println(startsWithJ);
    }
}
