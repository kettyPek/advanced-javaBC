package ajbc.serialization.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import ajbc.serialization.Student;
import ajbc.serialization.StudentDB;

/**
 * This is an implementation of TCP server
 */
public class TCPServer {
	
	private final int PORT;
	
	public TCPServer(int port) {
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
				
				// create reader
				bufferReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				
				// reading data
				String ReceivedID = bufferReader.readLine();
				System.out.println("Client says: " + ReceivedID);
				long id = Long.parseLong(ReceivedID);
				
				// get student from DB
				Student student = StudentDB.getStidentByID(id);
				
//				// sending data as a java serialized object
//				objectStream = new ObjectOutputStream(clientSocket.getOutputStream());
//				objectStream.writeObject(student);
//				System.out.println("Studnt sent to client: \n" + student);
				

				
				// creating data as JASON
				Gson gson = new Gson();
				String studentJson = gson.toJson(student,Student.class);
				
				// sending data as JSON
				writer = new PrintWriter(clientSocket.getOutputStream(),true);
				writer.println(studentJson);
				System.out.println("Studnt sent to client: \n" + student);

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
	
	public static void main(String[] args) throws IOException {
		
		TCPServer server = new TCPServer(8080);
		
		server.communicate();
	}

}
