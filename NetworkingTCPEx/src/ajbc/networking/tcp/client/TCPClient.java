package ajbc.networking.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	private final  String SERVER_NAME ;
	private final  int SERVER_PORT ;
	private final long ID;
	private Socket socket = null;
	
	public TCPClient(String serverName, int serverPort, long id) {
		this.SERVER_NAME = serverName;
		this.SERVER_PORT = serverPort;
		this.ID = id;
		try {
			socket = new Socket(SERVER_NAME,SERVER_PORT);
			System.out.println("Connected to server");
		} catch (IOException e) {
			System.out.println("Could not connect to server");
			e.printStackTrace();
		}
	}
	
	public void sendLocation() throws IOException {
		
		
		BufferedReader bufferReader = null;
		PrintWriter printer = null;
		
		try {
			
			// sending data
			printer = new PrintWriter(socket.getOutputStream(),true);
			printer.println("Hello");
			
			// reading data
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = bufferReader.readLine();
			System.out.println("Server says: " + line);
			
			
		} catch (UnknownHostException e) {
			System.out.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Socket failed");
			e.printStackTrace();
		}finally {
			if(socket!=null)
				socket.close();
			if(printer!=null)
				printer.close();
		}
	}
	
	public static void main(String[] args) throws IOException {	
		
		TCPClient client = new TCPClient("localhost",8080,123);
		
		Thread thread = new Thread(()->{
			try {
				for(int i=0; i<5; i++) {
					Thread.sleep(2000);
					client.sendLocation();
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
