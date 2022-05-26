package ajbc.networking.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ajbc.tracking_device.Location;

/**
 * This is an implementation of TCP server
 */
public class TCPServer {

	private final int PORT;
	private ServerSocket serverSocket = null;
	private Map<Long, List<Location>> locations;

	public TCPServer(int port) {

		this.PORT = port;
		locations = new HashMap<>();
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started on port " + PORT);
		} catch (IOException e) {
			System.out.println("Failed to start server on port " + PORT);
			e.printStackTrace();
		}
	}

	public void updateLocation() throws IOException {

		Socket clientSocket;
		BufferedReader bufferReader = null;
		PrintWriter writer = null;
		long id = 0;
		try {
			while (true) {

				clientSocket = serverSocket.accept();
				System.out.println(
						"Client is connected " + clientSocket.getInetAddress() + " on port " + clientSocket.getPort());

				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				// reading data
				String dataToRead = bufferReader.readLine();
				System.out.println("data" + dataToRead);

				try {
					id = Long.parseLong(dataToRead);
					System.out.println("id : " + id);
					writer = new PrintWriter(clientSocket.getOutputStream(), true);
					writer.println("id recived");
					
				} catch (Exception e) {
					List<Location> newLocation;
					String[] location = dataToRead.split("-");
					double longtitude = Double.parseDouble(location[0]);
					double altitude = Double.parseDouble(location[1]);
					LocalTime timeStamp = LocalTime.parse(location[2]);

					if (!locations.containsKey(id)) {
						newLocation = Arrays.asList(new Location(longtitude, altitude, timeStamp));
						locations.put(id, newLocation);
					} else
						locations.get(id).add(new Location(longtitude, altitude, timeStamp));
					writer = new PrintWriter(clientSocket.getOutputStream(), true);
					writer.println("Location added");
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (serverSocket != null)
				serverSocket.close();
			if (bufferReader != null)
				bufferReader.close();
			if (writer != null)
				writer.close();
		}
	}

	public static void main(String[] args) throws IOException {

		TCPServer server = new TCPServer(8080);

		server.updateLocation();
	}

}
