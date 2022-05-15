package ajbc.observer_ex;

public class Runner {

	public static void main(String[] args) {
		EventManager manager = new EventManager(ReportType.SPORTS,ReportType.GENERAL,ReportType.WEATHER);
		
		SmsSubscribers ketty = new SmsSubscribers(05467);
		manager.subscribe(ReportType.SPORTS,new SmsSubscribers(0546255345l));
		manager.subscribe(ReportType.SPORTS,new EmailSubscribes("ketty@gmail.com"));
		
		manager.subscribe(ReportType.GENERAL,ketty);
		manager.subscribe(ReportType.GENERAL,new EmailSubscribes("ketty@gmail.com"));
		
		manager.subscribe(ReportType.WEATHER,ketty);
		manager.subscribe(ReportType.WEATHER,new EmailSubscribes("ketty@gmail.com"));
		
		manager.notify(ReportType.SPORTS, new Report("Wariors Won!!"));
		manager.notify(ReportType.GENERAL, new Report("Peace finally arrived to the middle east"));
		manager.notify(ReportType.WEATHER,new Report("Volcano errapted in Hawaii"));
		
		System.out.println("--------");
		manager.unSubscribe(ReportType.GENERAL,ketty);
		manager.notify(ReportType.GENERAL, new Report("we lost a subscription"));
	}

}
