package ajbc.observer_ex;

public class Report {
	
	private String report;
	
	public Report(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Report: " + report;
	}
	
	

}
