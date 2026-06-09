package Main;

import java.util.ArrayList;

public class ExpenseManager {

    private ArrayList<Transaction> transactions;

    public ExpenseManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(int index) {
        transactions.remove(index);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public double calculateBalance() {
        double balance = 0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("Income")) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }

        return balance;
    }
}