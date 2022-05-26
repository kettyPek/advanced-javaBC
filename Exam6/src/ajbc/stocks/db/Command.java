package ajbc.stocks.db;

public class Command {

	String stockName;
	Operation operation;
	
	public Command(String stockName, Operation operation) {
		this.stockName = stockName;
		this.operation = operation;
	}
	
	public Operation getOperation() {
		return operation;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public static enum Operation{
		BUY, SELL;
	}
	
	
}
