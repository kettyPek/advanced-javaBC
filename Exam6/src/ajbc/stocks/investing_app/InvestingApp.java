package ajbc.stocks.investing_app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ajbc.stocks.db.Command;
import ajbc.stocks.db.Command.Operation;


public class InvestingApp {
	
	private static volatile double sum;
	private final int MAX_THREADS = 4;
	private ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);
	private List<Future<Double>> futures = new ArrayList<>();
	
	static {
		sum = 0;
	}
	
	
	public void transaction(Command command) {
		
		Future<Double> future;
		if(command.getOperation() == Operation.BUY)
			future = pool.submit(new BuyStock(command.getStockName()));
		else
			future = pool.submit(new SellStock(command.getStockName()));
		
		try {
			sum += future.get();
			futures.add(future);
			if(pool.isTerminated()) {
				pool.shutdown();
				pool.awaitTermination(2, TimeUnit.SECONDS);
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void transanctionFunds() {
		System.out.println("Transanctions funds: " + sum);
	}	

}
