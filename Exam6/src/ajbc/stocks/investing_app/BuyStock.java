package ajbc.stocks.investing_app;

import java.util.concurrent.Callable;

import ajbc.stocks.db.Stock;
import ajbc.stocks.db.StocksDB;

public class BuyStock implements Callable<Double> {

	private Stock stock = null;

	public BuyStock(String stockName) {
		try {
			stock = StocksDB.getStockByName(stockName);
		} catch (IllegalArgumentException e) {
			System.out.println("Wrong stock name, " + stockName + " doesnt exist in DB");
		}
	}

	@Override
	public Double call() throws Exception {
		if(stock==null)
			return 0.0;
		double stockPrice = stock.getBuyPrice();
		stock.increaseStock();

		return stockPrice;
	}

}
