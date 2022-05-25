package ajbc.networking.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import ajbc.exceptions.CityDoestExistException;

public class UDPClient {
	Scanner scanner = new Scanner(System.in);

	private final static int INPUT_BUFFER_SIZE = 1024;
	private String serverName;
	private int serverPort;
	private int clientPort;
	private DatagramSocket clientSocket;

	public UDPClient(String serverName, int serverPort, int clientPort) {
		this.serverName = serverName;
		this.serverPort = serverPort;
		this.clientPort = clientPort;

		// creating client socket
		try {
			clientSocket = new DatagramSocket(clientPort); // socket is a communication chanel
		} catch (SocketException e) {
			System.out.println("Client socket creation failed");
			e.printStackTrace();
		}

	}

	private void receiveData() throws CityDoestExistException {
		try {
			// prepare packet for receiving data from server
			byte[] buffer = new byte[INPUT_BUFFER_SIZE];
			DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);

			// receive data from server
			clientSocket.receive(receivedPacket);

			// extract massage from packet
			String serverMsg = new String(receivedPacket.getData());
			
			if(serverMsg.equals("FALSE")) {
				System.out.println("City doesnt exist, try again");
				throw new CityDoestExistException();
			}
			else {
				System.out.println("Please choose:\n1- Temprature\n2- Humidity\n3- Temprature & Humidity");
				String selection = scanner.next();
				byte[] msgBytes = selection.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(msgBytes, msgBytes.length,InetAddress.getByName(serverName), serverPort);
				clientSocket.send(packetToSend);
				
				buffer = new byte[INPUT_BUFFER_SIZE];
				receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);

				// receive data from server
				clientSocket.receive(receivedPacket);

				// extract massage from packet
				serverMsg = new String(receivedPacket.getData());
				System.out.println(serverMsg);
				
			}

		} catch (IOException e) {
			System.out.println("Client failed to send datagram");
			e.printStackTrace();
		}
	}

	public void sendData() throws CityDoestExistException {
		try {
			String city ="";
			do{
				// creating data
				System.out.println("Enter city:");
				city = scanner.next();

				// creating datagram
				byte[] msgBytes = city.getBytes();
				DatagramPacket packetToSend = new DatagramPacket(msgBytes, msgBytes.length,InetAddress.getByName(serverName), serverPort);
				
				// send packet
				clientSocket.send(packetToSend);
				
				receiveData();
				
			}while(!city.equals("ex"));
				
		} catch (UnknownHostException e) {
			System.out.println("Server address could not be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Client failed to send datagram");
			e.printStackTrace();
		} catch (CityDoestExistException e) {
			System.out.println("city");
			e.printStackTrace();
		} finally {
			System.out.println("client disconnected");
			if (clientSocket != null)
				clientSocket.close();
			scanner.close();
		}
	}

	public static void main(String[] args) throws CityDoestExistException {

		String serverName = "localhost";
		int serverPort = 4444;
		int port = 4445;

		UDPClient client = new UDPClient(serverName, serverPort, port);

		client.sendData();
	}

}
