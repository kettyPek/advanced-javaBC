package ajbc.stocks.investing_app;

import java.util.concurrent.Callable;

import ajbc.stocks.db.Stock;
import ajbc.stocks.db.StocksDB;

public class SellStock implements Callable<Double> {

	private Stock stock = null;

	public SellStock(String stockName) {
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
		double stockPrice = -1*stock.getSellPrice();
		stock.decreaseStock();

		return stockPrice;
	}

}
