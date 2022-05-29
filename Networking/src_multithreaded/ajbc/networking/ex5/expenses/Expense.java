package ajbc.networking.ex5.expenses;


public class Expense {
	
	private ExpenseCategory category;
	private double amount;
	
	
	public Expense(ExpenseCategory category, double amount) {
		this.category = category;
		this.amount = amount;
	}

	public ExpenseCategory getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	
	@Override
	public String toString() {
		return "Expense [category=" + category + ", amount=" + amount + "]";
	}

	public static  Expense randomExpense() {
		int num = (int)(Math.random()*4);
		double sum = (int)(Math.random()*300)+0.0;
		ExpenseCategory category = null;
		
		switch(num) {
		case 0:
			category = ExpenseCategory.CLOTHING;
			break;
		case 1:
			category = ExpenseCategory.FOOD;
			break;
		case 2:
			category = ExpenseCategory.TRANSPORTATION;
			break;
		case 3:
			category = ExpenseCategory.UTILITIES;
			break;
		}
		return new Expense(category,sum);
	}
	

}
