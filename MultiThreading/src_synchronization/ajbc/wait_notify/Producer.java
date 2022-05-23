package ajbc.wait_notify;

import java.util.Queue;

public class Producer implements Runnable {

	private final int MAX_REPORTS = 5;
	private final int PRODUCING_TIME = 1000;
	private final Queue<Report> reports;

	public Producer(Queue<Report> reports) {
		this.reports = reports;
	}

	@Override
	public void run() {
		while (true) {
			try {
				produceData();
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

	private void produceData() throws InterruptedException {
		synchronized (reports) {
			while (reports.size() == MAX_REPORTS) {
				System.out.println("In producer, waiting...");
				reports.wait();
			}

			Thread.sleep(PRODUCING_TIME);
			reports.add(new Report());
			System.out.println(Thread.currentThread().getName() + " is producing data with id " + Report.getCounter());

			// let consumer know that there is already 1 element in queue to consume
			if (reports.size() == 1)
				reports.notify();
		}
	}
}
