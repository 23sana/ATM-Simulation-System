package atm;


import java.util.ArrayList;


public class Account {
private int accountNumber;
private int pin;
private double balance;
private ArrayList<String> transactions;


public Account(int accountNumber, int pin, double balance) {
this.accountNumber = accountNumber;
this.pin = pin;
this.balance = balance;
transactions = new ArrayList<>();
}


public int getAccountNumber() {
return accountNumber;
}


public boolean validatePin(int inputPin) {
return this.pin == inputPin;
}


public double getBalance() {
return balance;
}


public void deposit(double amount) {
balance += amount;
transactions.add("Deposited: ₹" + amount);
}


public boolean withdraw(double amount) {
if (amount <= balance) {
balance -= amount;
transactions.add("Withdrawn: ₹" + amount);
return true;
}
return false;
}


public void printTransactions() {
if (transactions.isEmpty()) {
System.out.println("No transactions yet.");
} else {
System.out.println("\n--- Mini Statement ---");
for (String t : transactions) {
System.out.println(t);
}
}
}
}