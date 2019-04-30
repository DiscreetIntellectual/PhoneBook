import java.util.*;

public final class PhoneBook {

    private Map<String, Set<String>> book = new HashMap<String, Set<String>>();
    static private Set<String> check = new HashSet<String>(Arrays.asList("0123456789+*#-".split("")));

    public void addName(String name) {
        book.computeIfAbsent(name, k -> new HashSet<String>());
    }

    public void addPhone(String phone, String name) {
        if (check.containsAll(new HashSet<String>(Arrays.asList(phone.split("")))))
            if (book.get(name) != null)
                book.get(name).add(phone);
            else {
                addName(name);
                book.get(name).add(phone);
            }
        else
            throw new IllegalArgumentException("Phone number must consist only of digits and symbols \"+*#-\"");
    }

    public boolean deletePhone(String phone, String name) {
        if (book.get(name) != null) {
            if (!book.get(name).remove(phone)) return false;
        }
        else return false;
        return true;
    }

    public boolean deleteName(String name) {
        if (book.remove(name) == null)
            return false;
        return true;
    }

    public Set<String> getPhones(String name) {
        return new HashSet<String>(book.get(name) != null ? book.get(name) : new HashSet<>());
    }

    public String getNameByPhone(String phone) {
        for (Map.Entry<String, Set<String>> entry : book.entrySet())
            if (entry.getValue().contains(phone)) return entry.getKey();
        return null;
    }

    public Set<String> getNames() {
        return book.keySet();
    }

}

