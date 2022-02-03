import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        Pattern pattern = Pattern.compile("[a-z]*@[a-z]*.[a-z]*");
        String[] components = data.split("\\s+");

        if (components.length != 4) throw new IllegalArgumentException("Wrong format adding customer. " +
                "\nCorrect format: " + "add Василий Петров " +
                "vasily.petrov@gmail.com +79215637723");
        Matcher matcher = pattern.matcher(components[INDEX_EMAIL]);
        if (!matcher.find())
            throw new IncorrectEmailException(components[INDEX_EMAIL] );
        if (components[INDEX_PHONE].length() != 12)
            throw new IncorrectPhoneNumberException(components[INDEX_PHONE]);

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
          if (storage.remove(name) == null) throw new IllegalArgumentException("Wrong name");
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}

//    public void addCustomer(String data) throws ArrayIndexOutOfBoundsException {
//
//        final int INDEX_NAME = 0;
//        final int INDEX_SURNAME = 1;
//        final int INDEX_EMAIL = 2;
//        final int INDEX_PHONE = 3;
//
//        Pattern pattern = Pattern.compile("[a-z]*@[a-z]*.[a-z]*");
//        String[] components = data.split("\\s+");
//
//        if (components.length != 4) throw new ArrayIndexOutOfBoundsException("Wrong format adding customer. " +
//                "\nCorrect format: " + "add Василий Петров " +
//                "vasily.petrov@gmail.com +79215637723");
//        Matcher matcher = pattern.matcher(components[INDEX_EMAIL]);
//        if (!matcher.find())
//            throw new IllegalArgumentException("Wrong Email format. Correct format: vasily.petrov@gmail.com" );
//        if (components[INDEX_PHONE].length() != 12)
//            throw new IllegalArgumentException("Wrong phone number format. Correct format: +79215637722");
//
//        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
//        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
//    }