package atm;


import java.util.HashMap;


public class Bank {
private HashMap<Integer, Account> accounts;


public Bank() {
accounts = new HashMap<>();


// Sample accounts
accounts.put(12345, new Account(12345, 1111, 5000));
accounts.put(67890, new Account(67890, 2222, 10000));
}


public Account authenticate(int accNumber, int pin) {
Account acc = accounts.get(accNumber);
if (acc != null && acc.validatePin(pin)) {
return acc;
}
return null;
}
}