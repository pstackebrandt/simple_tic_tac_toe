import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var firstDate = getSeconds(scan.nextInt(), scan.nextInt(), scan.nextInt());
        var secondDate = getSeconds(scan.nextInt(), scan.nextInt(), scan.nextInt());

        System.out.println(secondDate - firstDate);
    }

    static int getSeconds(int hours, int minutes, int seconds) {
        final int minutesPerHour = 60;
        final int secondsPerMinute = 60;

        return (hours * minutesPerHour + minutes) * secondsPerMinute + seconds;
    }
}