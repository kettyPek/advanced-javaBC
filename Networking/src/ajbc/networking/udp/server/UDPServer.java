package ajbc.networking.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * This is an implementation of UDP server
 * UDP server doesnt need to check the data that was send.
 */
public class UDPServer {
	
	private final static int INPUT_BUFFER_SIZE = 1024;
	private final static int OUTPUT_BUFFER_SIZE = 1024;
	private int port;
	private DatagramSocket serverSocket;
	
	public UDPServer(int port) {
		this.port = port;
		
		try {
			serverSocket = new DatagramSocket(port);
			System.out.println("Server: " + port);
		} catch (SocketException e) {
			System.out.println("Connaction failed");
			e.printStackTrace();
		}
	}
	
	public void echoData() {
		try {
			while(true) {
				
				// handle data
				byte[] buffer = new byte [INPUT_BUFFER_SIZE];
				DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);
				
				// this is a blocking method
				serverSocket.receive(receivedPacket); 
				
				// get client address info
				InetAddress clietAddress = receivedPacket.getAddress();
				int clietPort = receivedPacket.getPort();
				
				// get client massage
				String clientMsg = new String(receivedPacket.getData()).trim();
				
				// print clieant massage for debugging
				System.out.println("client " + clietAddress + " sent: " + clientMsg);
				
				// preper packet for sending
				byte[] myBytes = clientMsg.getBytes();
				DatagramPacket packetToSent = new DatagramPacket(myBytes,myBytes.length,clietAddress,clietPort);
				
				// sent packet back to client
				serverSocket.send(packetToSent);
				System.out.println("Server echo response sent");
			
			}
			
		} catch (IOException e) {
			System.out.println("Server failed to connect with client");
			e.printStackTrace();
		}		
	}
		
	
	public static void main(String[] args) {
		
		int port = 4444;
		UDPServer server = new UDPServer(port);
		server.echoData();
		
	}

}
