import java.util.*;

public final class PhoneBook {

    private Map<String, Set<String>> book = new HashMap<String, Set<String>>();

    public void addName(String name) {
        book.computeIfAbsent(name, k -> new HashSet<String>());
    }

    public void addPhone(String phone, String name) {
        Set<String> check = new HashSet<String>(Arrays.asList("0123456789+*#-".split("")));
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
        if (book.get(name) != null)
            book.get(name).remove(phone);
        else return false;
        return true;
    }

    public boolean deleteName(String name) {
        if (book.containsKey(name))
            book.remove(name);
        else return false;
        return true;
    }

    public Set<String> getPhones(String name) {
        return book.get(name);
    }

    public String getNameByPhone(String phone) {
        for (Map.Entry<String, Set<String>> entry : book.entrySet())
            if (entry.getValue().contains(phone)) return entry.getKey();
        return null;
    }

    public Set getNames() {
        return book.keySet();
    }

}

