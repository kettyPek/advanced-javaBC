package ajbc.observer_ex;

public class EmailSubscribes implements ReportSubscriber{
	
	private String email;
	
	public EmailSubscribes(String email) {
		this.email = email;
	}

	@Override
	public void update(ReportType reportType,Report report) {
		System.out.println(reportType + " news report sent to email: " + email + report);
		
	}
	
	

}
