package ajbc.networking.ex5.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import ajbc.networking.ex5.expenses.Expense;
import ajbc.networking.ex5.expenses.ExpenseCategory;
import ajbc.networking.ex5.user.User;

public class AppServer {

	private final int USERS_AMOUNT = 1000;
	private final int PORT;
	private List<User> users;

	public AppServer(int port) {
		this.PORT = port;
		users = randomUsers(USERS_AMOUNT);
	}

	public void startServer() throws InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();

		try (ServerSocket serverSocket = new ServerSocket(PORT);) {

			System.out.println("App Server started on port " + PORT);

			while (true) {
				Socket clientSocket = serverSocket.accept();
				executorService.execute(new AppServerRunnable(clientSocket));
			}
		} catch (IOException e) {
			System.err.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		} finally {
			executorService.shutdown();
			executorService.awaitTermination(2, TimeUnit.SECONDS);
		}

	}

	private class AppServerRunnable implements Runnable {

		private Socket clientSocket;

		public AppServerRunnable(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			long userID = 0;
			try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);) {

				System.out.println(
						"Client is connected " + clientSocket.getInetAddress() + " port " + clientSocket.getPort());
				// reading data
				String id = bufferReader.readLine();
				System.out.println("user ID : " + id);

				userID = Long.parseLong(id);
				writer.println("user ID received");

				String userExpense = bufferReader.readLine();
				System.out.println("user expense: " + userExpense);

				// parsing JSON to Expense
				Gson gson = new Gson();

				Expense expense = gson.fromJson(userExpense, Expense.class);
				if (!userExist(userID))
					writer.println("user doesnt exist");
				else {
					User user = getUserByID(userID);
					System.out.println(user);
					System.out.println("got user by id");
					updateUserExpenses(user,expense);
					writer.println(user.getExpenses().entrySet());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private boolean userExist(long id) {
		for (var user : users)
			if (user.getID() == id)
				return true;
		return false;
	}

	private User getUserByID(long id) {
		for (var user : users)
			if (user.getID() == id)
				return user;
		return null;
	}

	private List<User> randomUsers(int amount) {

		List<User> users = new ArrayList<User>();
		for (int i = 0; i < amount; i++)
			users.add(new User());
		return users;
	}

	private void updateUserExpenses(User user, Expense expense) {
		ExpenseCategory category = expense.getCategory();
		Double sum;
		if (user.getExpenses().containsKey(category))
			sum = user.getExpenses().get(category) + expense.getAmount();
		else
			sum = expense.getAmount();
		user.getExpenses().put(category, sum);
	}

}
