package ajbc.stocks.db;

public class Stock {

	private String name;
	private double buyPrice;
	private double sellPrice;
	
	public Stock(String name, double buyPrice, double sellPrice) {
		setName(name);
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	private void setName(String name) {
		if(StockName.valueOf(name.toUpperCase()) != null) { //throws IllegalArgumentException
			this.name=name;
		}
	}
	
	public void increaseStock() {
		buyPrice += 0.02;
	}
	
	public void decreaseStock() {
		sellPrice -= 0.01;
	}
	
	public double getBuyPrice() {
		return buyPrice;
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	
	@Override
	public String toString() {
		return "Stock [name=" + name + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice + "]";
	}
//	public static void main(String[] args) {
//		Stock stock = new Stock("doodle", 3.0, 4.0);
//		System.out.println(stock);
//	}
}
