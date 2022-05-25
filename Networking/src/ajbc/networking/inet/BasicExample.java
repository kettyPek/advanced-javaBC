package ajbc.networking.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BasicExample {
	
	public static void main(String[] args) throws UnknownHostException {
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		String hostName = InetAddress.getLocalHost().getHostName();
		System.out.println("Host address: " + ip + ", host name: " + hostName);
		
		InetAddress technionAdress = InetAddress.getByName("technion.ac.il");
		System.out.println("\nTechnion ip address and host name: " + technionAdress);
		
		InetAddress facebokAddress = InetAddress.getByName("facebook.com");
		System.out.println("\nFacebook ip address and host name: " + facebokAddress);
	}

}
