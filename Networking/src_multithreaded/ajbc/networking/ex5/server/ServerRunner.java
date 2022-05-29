package ajbc.networking.ex5.server;

public class ServerRunner {
	
	public static void main(String[] args) throws InterruptedException {
		
		int port = 8090;
		
		AppServer appServer = new AppServer(port);
		
		appServer.startServer();

	}

}
