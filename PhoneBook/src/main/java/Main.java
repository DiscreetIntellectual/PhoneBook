import java.util.*;

public class Main {
    public static void main(String args[]) {
        PhoneBook lol = new PhoneBook();
        lol.addName("Jin");
        try {
            lol.addPhone("^_^", "Jin");
        }
        catch (IllegalArgumentException e) {
            System.out.println("It's ok");
        }
        lol.addName("Jin");
        System.out.println(lol.getNames());
    }
}
