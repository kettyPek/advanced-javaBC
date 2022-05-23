package ajbc.wait_notify;

public class Report {
	
	private static int counter;
	private String details;
	
	static {
		counter = 0;
	}
	
	public Report(){
		counter++;
		details = "Retport Number " + counter;
	}
	
	public static int getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return "Report [details=" + details + "]";
	}

}
