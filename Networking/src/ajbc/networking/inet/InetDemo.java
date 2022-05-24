package ajbc.networking.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetDemo {
	
	public static void main(String[] args) throws UnknownHostException {
		
		// Obtain computer's ip
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		
		// ip and host name as Strings
		String ip = address.getHostAddress();
		String hostName = address.getHostName();
		
		System.out.println("ip: " + ip + ", host name: " + hostName);
		
		// Get Inetaddress by host name
		InetAddress addressByName = InetAddress.getByName(hostName);
		System.out.println("\nInetaddress by name: " + addressByName);
		
		// Get Inetaddress by ip
		InetAddress addressByIP = InetAddress.getByName(ip);
		System.out.println("\nInetaddress by ip: " + addressByIP);
		
		// Get Inetaddress by website name
		InetAddress addressByWebsiteName = InetAddress.getByName("google.com");
		System.out.println("\nInetaddress by website name: " + addressByWebsiteName);
		
		// Get all Inetaddress by website name
		InetAddress [] addresses = InetAddress.getAllByName("google.com");
		System.out.println("\nAll inetaddresses by website name: ");
		System.out.println(Arrays.toString(addresses));
		
		// Loopback address
		InetAddress myLoop = InetAddress.getLoopbackAddress();
		System.out.println("\nMy loop: " + myLoop);
	}

}
