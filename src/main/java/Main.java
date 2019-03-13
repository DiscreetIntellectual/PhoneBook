import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        PhoneBook lol = new PhoneBook();
        lol.addName("Jin");
        lol.addPhone("+79503085511", "Ji");
        lol.addPhone("+7", "Jin");
        System.out.println(lol.book.get("J") == null);
        System.out.println(lol.getName("+79503085511"));
        System.out.println(lol.getName("+7"));
    }
}
