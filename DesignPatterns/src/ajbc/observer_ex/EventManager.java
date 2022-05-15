package ajbc.observer_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

	Map<ReportType, List<ReportSubscriber>> emailSubscribers = new HashMap<>();
	Map<ReportType, List<ReportSubscriber>> smsSubscribers = new HashMap<>();

	public EventManager(ReportType... reportTypes) {
		for (var reprtType : reportTypes) {
			emailSubscribers.put(reprtType, new ArrayList<ReportSubscriber>());
			smsSubscribers.put(reprtType, new ArrayList<ReportSubscriber>());
		}
	}

	public void subscribe(ReportType reportType, EmailSubscribes emailSubscriber) {
		List<ReportSubscriber> subscribers = emailSubscribers.get(reportType);
		subscribers.add(emailSubscriber);
	}

	public void subscribe(ReportType reportType, SmsSubscribers smsSubscriber) {
		List<ReportSubscriber> subscribers = smsSubscribers.get(reportType);
		subscribers.add(smsSubscriber);
	}
	
	public void unSubscribe(ReportType reportType, ReportSubscriber smsSubscriber) {
		List<ReportSubscriber> subscribers = emailSubscribers.get(reportType);
		subscribers.remove(smsSubscriber);
		subscribers = smsSubscribers.get(reportType);
		subscribers.remove(smsSubscriber);
	}

	public void notify(ReportType reportType ,Report report) {
		emailSubscribers.get(reportType).forEach(subscriber -> subscriber.update(reportType,report));
		smsSubscribers.get(reportType).forEach(subscriber -> subscriber.update(reportType,report));
	}

}
