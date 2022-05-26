package ajbc.networking.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import ajbc.networking.restaurant.Order;
import ajbc.serialization.Student;
import ajbc.serialization.StudentDB;

/**
 * This is an implementation of TCP server
 */
public class Server {
	
	private final int PORT;
	
	public Server(int port) {
		this.PORT = port;
	}
	
	public void communicate() throws IOException {
		
		ServerSocket serverSocket = null;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		ObjectOutputStream objectStream  = null;
		try {
			// start server
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);
			
			while(true) {
				
				//3 way handshake
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client is connected " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());
						
				// reading data as JSON
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	
				String json = bufferReader.readLine();
				System.out.println("Server json: " + json);
				
				// parsing JSON to Studnt
				Gson gson = new Gson();
				Order order = gson.fromJson(json, Order.class);
				System.out.println("Order : " + order);
				
				float bill = calculateBill(order);
				writer = new PrintWriter(clientSocket.getOutputStream(),true);
				writer.println(bill);
			}
			
		} catch (IOException e) {
			System.out.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			if(bufferReader != null)
				bufferReader.close();
			if(writer != null)
				writer.close();
			if(objectStream != null)
				objectStream.close();
		}
	}
	
	private float calculateBill(Order order) {
		return order.getDishes().stream().map(dish -> dish.getPrice()).reduce(0f, (subtotal, element) -> subtotal + element);
	}
	
	public static void main(String[] args) throws IOException {
		
		Server server = new Server(8080);
		
		server.communicate();
	}

}
