package ajbc.networking.ex5.user;

import java.util.HashMap;
import java.util.Map;

import ajbc.networking.ex5.expenses.ExpenseCategory;

public class User {
	
	private static int counter;
	private final long ID;
	private Map<ExpenseCategory,Double> expenses;
	
	static {
		counter = 0;
	}
	
	public User() {
		this.ID = counter++;
		this.expenses = new HashMap<ExpenseCategory,Double>();
	}
	
	public long  getID() {
		return ID;
	}
	
	public Map<ExpenseCategory, Double> getExpenses() {
		return expenses;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", expenses=" + expenses + "]";
	}
	
}
