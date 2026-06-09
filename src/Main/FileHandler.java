package Main;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveTransactions(ArrayList<Transaction> transactions, String fileName) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Transaction t : transactions) {
            writer.write(t.toString());
            writer.newLine();
        }

        writer.close();
    }

    public static ArrayList<Transaction> loadTransactions(String fileName) throws IOException {

        ArrayList<Transaction> transactions = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            String description = data[0];
            double amount = Double.parseDouble(data[1]);
            String type = data[2];

            transactions.add(new Transaction(description, amount, type));
        }

        reader.close();

        return transactions;
    }
}