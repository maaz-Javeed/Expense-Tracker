package Main;

public class Transaction {
    private String description;
    private double amount;
    private String type;

    public Transaction(String description, double amount, String type) {
        this.description = description;
        this.amount = amount;
        this.type = type;

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return description + "," + amount + "," + type;
    }
}

