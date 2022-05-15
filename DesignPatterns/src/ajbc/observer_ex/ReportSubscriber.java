package ajbc.observer_ex;

public interface ReportSubscriber {
	
	void update(ReportType reportType,Report report);

}
