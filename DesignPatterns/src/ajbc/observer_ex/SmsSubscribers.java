package ajbc.observer_ex;

public class SmsSubscribers implements ReportSubscriber{
	
	private long phoneNumber;
	
	public SmsSubscribers(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public void update(ReportType reportType,Report report) {
		System.out.println(reportType + " news report sent SMS to number: " + phoneNumber + report);
		
	}
	

}
