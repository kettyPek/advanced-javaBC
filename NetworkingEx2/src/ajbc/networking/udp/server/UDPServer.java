package ajbc.networking.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import ajbc.forecast.Forecast;

/**
 * This is an implementation of UDP server UDP server doesnt need to check the
 * data that was send.
 */
public class UDPServer {
	private final static int INPUT_BUFFER_SIZE = 1024;
	private int port;
	private DatagramSocket serverSocket;
	private List<Forecast> forecasts;
	private Forecast currentForecast;

	public UDPServer(int port) {
		this.port = port;
		initializeForecasts();

		try {
			serverSocket = new DatagramSocket(port);
			System.out.println("Server: " + port);
		} catch (SocketException e) {
			System.out.println("Connaction failed");
			e.printStackTrace();
		}
	}

	private void initializeForecasts() {

		forecasts = new ArrayList<>();
		forecasts.add(new Forecast("Haifa", 27, 80));
		forecasts.add(new Forecast("Tel Aviv", 25, 60));
		forecasts.add(new Forecast("Eilat", 30, 20));
		forecasts.add(new Forecast("Jerusalem", 23, 30));
		forecasts.add(new Forecast("Rehovot", 29, 55));
	}

	private boolean cityExist(String city) {

		for (var forecast : forecasts)
			if (forecast.getCity().equals(city)) {
				currentForecast = forecast;
				return true;
			}
		return false;
	}

	private String manageSelection(int selection) {

		switch (selection) {
		case 1:
			return "Temprature: " + currentForecast.getTemprature();
		case 2:
			return "Humidity: " + currentForecast.getHumidityPercent();
		case 3:
			return "Temprature: " + currentForecast.getTemprature() + "\n" + "Humidity: "
					+ currentForecast.getHumidityPercent();
		default:
			return "Wrong input";
		}
	}

	public void echoData() {
		byte[] myBytes;
		try {
			while (true) {

				// handle data
				byte[] buffer = new byte[INPUT_BUFFER_SIZE];
				DatagramPacket receivedPacket = new DatagramPacket(buffer, INPUT_BUFFER_SIZE);

				// this is a blocking method
				serverSocket.receive(receivedPacket);

				// get client address info
				InetAddress clietAddress = receivedPacket.getAddress();
				int clietPort = receivedPacket.getPort();

				// get client massage
				String data = new String(receivedPacket.getData());
				
				try {
					int selection = Integer.parseInt(data);
					myBytes = manageSelection(selection).getBytes();
	
				}catch(Exception e) {
					if(cityExist(data))
						myBytes = ("true").getBytes();
					else
						myBytes = ("City doesnt exist").getBytes();
				}
				
				DatagramPacket packetToSent = new DatagramPacket(myBytes, myBytes.length, clietAddress, clietPort);
				serverSocket.send(packetToSent);
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
