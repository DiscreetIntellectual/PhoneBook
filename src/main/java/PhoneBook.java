import java.util.HashMap;
import java.util.ArrayList;

final class PhoneBook {

    HashMap<String, ArrayList<String>> book = new HashMap<String, ArrayList<String>>();

    void addName(String name) {
        if (book.get(name) == null)
            book.put(name, new ArrayList<String>());
    }

    void addPhone(String phone, String name) {
        if (book.get(name) != null)
            book.get(name).add(phone);
    }

    void deletePhone(String phone, String name) {
        book.get(name).remove(phone);
    }

    void deleteName(String name) {
        book.remove(name);
    }

    ArrayList<String> getPhones(String name) {
        return book.get(name) == null ? new ArrayList<String>() : book.get(name);
    }

    String getName(String phone) {
        for (HashMap.Entry<String, ArrayList<String>> entry : book.entrySet())
            if (entry.getValue().contains(phone)) return entry.getKey();
        return "This number is not associated with any name";
    }

}

