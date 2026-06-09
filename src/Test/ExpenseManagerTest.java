package Test;

import Main.ExpenseManager;
import Main.Transaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExpenseManagerTest {

    @Test
    public void testAddTransaction(){
        ExpenseManager manager = new ExpenseManager();

        manager.addTransaction(new Transaction("Salary", 5000, "Income"));

        assertEquals(1, manager.getTransactions().size());
    }
    @Test
    public void testIncomeCalculation() {

        ExpenseManager manager = new ExpenseManager();

        manager.addTransaction(new Transaction("Salary",5000,"Income"));

        assertEquals(5000, manager.calculateBalance(), 0.01);  //Delta handles problems that can be caused by using decimal values
    }

    @Test
    public void testExpenseCalculation() {

        ExpenseManager manager = new ExpenseManager();

        manager.addTransaction(new Transaction("Food",1000,"Expense")
        );

        assertEquals(-1000, manager.calculateBalance(),0.01);
    }

    @Test
    public void testMixedTransactions() {

        ExpenseManager manager = new ExpenseManager();

        manager.addTransaction(new Transaction("Salary",5000,"Income"));

        manager.addTransaction(new Transaction("Food", 1000, "Expense"));

        manager.addTransaction(new Transaction("Transport",500,"Expense"));

        assertEquals(3500,manager.calculateBalance(), 0.01);
    }

    @Test
    public void testRemoveTransaction() {

        ExpenseManager manager = new ExpenseManager();

        manager.addTransaction(new Transaction("Salary",5000,"Income"));

        manager.removeTransaction(0);

        assertEquals(0,manager.getTransactions().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmount() {

        new Transaction("Food", -500, "Expense");
    }
}
