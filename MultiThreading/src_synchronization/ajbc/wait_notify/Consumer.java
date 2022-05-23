package ajbc.wait_notify;

import java.util.Queue;

public class Consumer implements Runnable {

	private final int CONSUMING_TIME = 500;
	private final Queue<Report> reports;

	public Consumer(Queue<Report> reports) {
		this.reports = reports;
	}

	@Override
	public void run() {
		while (true) {
			try {
				consumeData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consumeData() throws InterruptedException {
		synchronized (reports) {
			while (reports.isEmpty()) {
				System.out.println("Consumer is waiting...");
				reports.wait();
			}

			Thread.sleep(CONSUMING_TIME);

			Report data = reports.remove();
			System.out.println("Consumed data: " + data);

			// let producer know that the consuming started
			if (reports.size() == 1) {
				reports.notify();
			}
		}
	}
}
