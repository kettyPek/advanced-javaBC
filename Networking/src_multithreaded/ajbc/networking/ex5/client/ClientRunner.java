package ajbc.networking.ex5.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import ajbc.networking.ex5.expenses.Expense;

public class ClientRunner {
	
	public static void main(String[] args) throws InterruptedException {
		
		final int USERS_IN_SERVER = 1000;
		final int SIMULATIONS = 10;
		final String SERVER_NAME = "localhost";
		final int SERVER_PORT = 8090;
		
		ExecutorService clientsService = Executors.newFixedThreadPool(SIMULATIONS);
		CountDownLatch latch = new CountDownLatch(SIMULATIONS-1);
		for (int i = 0; i < SIMULATIONS; i++) {
			int randomID = (int)(Math.random()*USERS_IN_SERVER);
			Expense randomExpense = Expense.randomExpense();
			clientsService.execute(new AppClient(SERVER_NAME,SERVER_PORT,randomID, randomExpense,latch));
		}
		clientsService.shutdown();
		clientsService.awaitTermination(20, TimeUnit.SECONDS);
	}
	

}
