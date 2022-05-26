package ajbc.serialization.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ClientInfoStatus;

import com.google.gson.Gson;

import ajbc.serialization.Student;

public class TCPClient {

	private final  String SERVER_NAME ;
	private final  int SERVER_PORT ;
	
	public TCPClient(String serverName, int serverPort) {
		this.SERVER_NAME = serverName;
		this.SERVER_PORT = serverPort;
	}
	
	public void communicate() throws IOException {
		
		Socket socket = null;
		BufferedReader bufferReader = null;
		PrintWriter printer = null;
		ObjectInputStream objectStream = null ;
		
		try {
			socket = new Socket(SERVER_NAME,SERVER_PORT);
			System.out.println("Connected to server");
			
			// sending data
			printer = new PrintWriter(socket.getOutputStream(),true);
			printer.println("10001");

//			// reading data as java serialized object
//			objectStream = new ObjectInputStream(socket.getInputStream());
//			Student student = (Student)objectStream.readObject();
//			System.out.println(student);
			
			// reading data as JSON
			bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
			String json = bufferReader.readLine();
			System.out.println("Server jason: " + json);
			
			// parsing JSON to Studnt
			Gson gson = new Gson();
			Student student = gson.fromJson(json, Student.class);
			System.out.println("Student : " + student);

			
		} catch (UnknownHostException e) {
			System.out.println("Server is not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Socket failed");
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			System.out.println("deserialization didnt work");
//			e.printStackTrace();
		}finally {
			if(socket!=null)
				socket.close();
			if(printer!=null)
				printer.close();
			if(objectStream!=null)
				objectStream.close();
		}
	}
	
	public static void main(String[] args) throws IOException {	
		
		TCPClient client = new TCPClient("localhost",8080);
		
		Thread thread = new Thread(()->{
			try {
				for(int i=0; i<5; i++) {
					Thread.sleep(2000);
					client.communicate();
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
