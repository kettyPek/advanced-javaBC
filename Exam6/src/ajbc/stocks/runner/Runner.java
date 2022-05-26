package ajbc.stocks.runner;

import java.util.Arrays;
import java.util.List;

import ajbc.stocks.db.Command;
import ajbc.stocks.db.Command.Operation;
import ajbc.stocks.db.StocksDB;
import ajbc.stocks.investing_app.InvestingApp;

public class Runner {

	public static void main(String[] args) {
		
		InvestingApp investingApp = new InvestingApp();
		
		List<Command> commands = Arrays.asList(
				new Command("doodle", Operation.BUY),
				new Command("barvazon", Operation.BUY),
				new Command("headbook", Operation.BUY),
				new Command("doodle", Operation.SELL),
				new Command("barvazon", Operation.SELL),
				new Command("headbook", Operation.SELL),
				new Command("doodle", Operation.BUY),
				new Command("barvazon", Operation.BUY),
				new Command("headbook", Operation.BUY),
				new Command("doodle", Operation.SELL),
				new Command("poodle", Operation.SELL)
				);

		StocksDB.printStockDB();
		
		System.out.println("\n----initial transanction funds----");
		investingApp.transanctionFunds();
		
		System.out.println("\nTransacanction started :");
		commands.forEach(command -> investingApp.transaction(command));
		
		System.out.println("\n----final stocks information----");
		StocksDB.printStockDB();	
		
		System.out.println("\n----final transanction funds----");
		investingApp.transanctionFunds();
	}

}
