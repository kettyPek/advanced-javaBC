package ajbc.networking.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import ajbc.networking.restaurant.Dish;
import ajbc.networking.restaurant.Order;

public class Client {

	private final String SERVER_NAME;
	private final int SERVER_PORT;

	public Client(String serverName, int serverPort) {
		this.SERVER_NAME = serverName;
		this.SERVER_PORT = serverPort;
	}

	public void sendOrder(Order order) throws IOException {

		Socket socket = null;
		BufferedReader bufferReader = null;
		PrintWriter printer = null;
		ObjectInputStream objectStream = null;
		PrintWriter writer = null;

		try {
			socket = new Socket(SERVER_NAME, SERVER_PORT);
			System.out.println("Connected to server");

			// creating data as JASON
			Gson gson = new Gson();
			String orderJson = gson.toJson(order, Order.class);

			// sending data as JSON
			writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println(orderJson);
			System.out.println("Order sent to the server");

			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String bill = bufferReader.readLine();
			System.out.println("Server says: " + bill);

		} catch (UnknownHostException e) {
			System.out.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Socket failed");
			e.printStackTrace();
		} finally {
			if (socket != null)
				socket.close();
			if (printer != null)
				printer.close();
			if (objectStream != null)
				objectStream.close();
		}
	}

	public static void main(String[] args) throws IOException {

		Client client = new Client("localhost", 8080);

		List<Dish> dishes = Arrays.asList(new Dish("Pizza",100),new Dish("Pizza",100));
		Order order = new Order(dishes);
		
		Thread thread = new Thread(() -> {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(2000);
					client.sendOrder(order);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		thread.start();

	}
}
