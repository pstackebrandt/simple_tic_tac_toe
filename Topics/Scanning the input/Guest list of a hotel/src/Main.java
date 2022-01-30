import java.util.*;

class Main {
    public static void main(String[] args) {
        var guests = new Scanner(System.in).tokens().toArray();
        var list = Arrays.asList(guests);
        Collections.reverse(list);
        list.forEach(System.out::println);
    }
}