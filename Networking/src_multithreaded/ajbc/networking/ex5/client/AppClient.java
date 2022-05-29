package ajbc.networking.ex5.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

import com.google.gson.Gson;

import ajbc.networking.ex5.expenses.Expense;
import ajbc.networking.ex5.user.User;

public class AppClient implements Runnable {

	private final String SERVER_NAME;
	private final int SERVER_PORT;
	private long id;
	private Expense expense;
	private CountDownLatch latch ;

	public AppClient(String serverName, int serverPort, long id, Expense expense,CountDownLatch latch ) {
		this.SERVER_NAME = serverName;
		this.SERVER_PORT = serverPort;
		this.id = id;
		this.expense = expense;
		this.latch = latch;
	}

	@Override
	public void run() {

		latch.countDown();
		try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try (Socket socket = new Socket(SERVER_NAME, SERVER_PORT);
				BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {

			System.out.println("Connected to server");

			// sending data as JSON
			writer.println(id);
			String answer = bufferReader.readLine();
			System.out.println("Server says: " + answer);

			// creating data as JASON
			Gson gson = new Gson();
			System.out.println(expense);
			String expeneJson = gson.toJson(expense,expense.getClass());
			writer.println(expeneJson);
			System.out.println("expense sent to the server");

			String report = bufferReader.readLine();
			System.out.println("Server says: " + report);

		} catch (UnknownHostException e) {
			System.out.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Socket failed");
			e.printStackTrace();
		}
	}

}
