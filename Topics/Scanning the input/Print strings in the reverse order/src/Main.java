import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var profile = new Scanner(System.in).tokens().toArray(String[]::new);
        for (int i = profile.length - 1; i >= 0; i--) {
            System.out.println(profile[i]);
        }
    }
}