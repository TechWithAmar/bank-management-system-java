import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accNo, String name, String password) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists!");
        } else {
            accounts.put(accNo, new Account(accNo, name, password));
            System.out.println("Account Created Successfully!");
        }
    }

    public Account login(String accNo, String password) {
        Account acc = accounts.get(accNo);
        if (acc != null && acc.getPassword().equals(password)) {
            return acc;
        }
        return null;
    }
}
