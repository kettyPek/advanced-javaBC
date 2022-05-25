package ajbc.networking.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is an implementation of TCP server
 */
public class TCPServer {
	
	private final int PORT;
	private ServerSocket serverSocket = null;
	
	public TCPServer(int port) {
		
		this.PORT = port;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);
		} catch (IOException e) {
			System.out.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		}
	}
	
	public void updateLocation() throws IOException {
		
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		try {
			while(true) {
				
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client is connected " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());
				
				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				
				// reading data
				String line = bufferReader.readLine();
				System.out.println("Client says: " + line);
				
				writer = new PrintWriter(clientSocket.getOutputStream(),true);
				writer.println("I must have called");
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			if(serverSocket != null)
				serverSocket.close();
			if(bufferReader != null)
				bufferReader.close();
			if(writer != null)
				writer.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		TCPServer server = new TCPServer(8080);
		
		server.updateLocation();
	}

}
