package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class ExpenseTrackerGUI extends JFrame {

    private JTextField txtDescription;
    private JTextField txtAmount;

    private JRadioButton incomeButton;
    private JRadioButton expenseButton;

    private JTable table;
    private DefaultTableModel model;

    private JLabel balanceLabel;

    private ExpenseManager manager;

    public ExpenseTrackerGUI() {

        manager = new ExpenseManager();

        setTitle("Personal Expense Tracker");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeUI();

        setVisible(true);
    }

    private void initializeUI() {

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        txtDescription = new JTextField();
        txtAmount = new JTextField();

        incomeButton = new JRadioButton("Income");
        expenseButton = new JRadioButton("Expense");

        ButtonGroup group = new ButtonGroup();
        group.add(incomeButton);
        group.add(expenseButton);

        incomeButton.setSelected(true);

        JButton addButton = new JButton("Add Transaction");
        JButton deleteButton = new JButton("Delete");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        inputPanel.add(new JLabel("Description"));
        inputPanel.add(txtDescription);

        inputPanel.add(new JLabel("Amount"));
        inputPanel.add(txtAmount);

        inputPanel.add(incomeButton);
        inputPanel.add(expenseButton);

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        model = new DefaultTableModel(
                new String[]{"Description", "Amount", "Type"}, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel bottomPanel = new JPanel();

        saveButton.setPreferredSize(new Dimension(100, 30));
        loadButton.setPreferredSize(new Dimension(100, 30));

        bottomPanel.add(saveButton);
        bottomPanel.add(loadButton);

        balanceLabel = new JLabel("Balance: Rs. 0");

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());

        southPanel.add(balanceLabel, BorderLayout.NORTH);
        southPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(southPanel, BorderLayout.SOUTH);

        /*addButton.addActionListener(e -> addTransaction());

        deleteButton.addActionListener(e -> deleteTransaction());

        saveButton.addActionListener(e -> saveData());

        loadButton.addActionListener(e -> loadData());*/
    }



    public static void main(String[] args) {
        new ExpenseTrackerGUI();
    }
}
