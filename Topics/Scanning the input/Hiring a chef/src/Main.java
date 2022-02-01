import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var profile = new Scanner(System.in).tokens().toArray(String[]::new);
        var msg = String.format("The form for %s is completed.", profile[0]);
        msg += String.format(" We will contact you if we need a chef who cooks %s dishes", profile[2]);
        msg += String.format(" and has %s years of experience.", profile[1]);

        System.out.println(msg);
    }
}
