package ajbc.condition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {

	private final int MAX_REPORTS = 5;
	private final int PRODUCING_TIME = 1000;
	private final Queue<Report> reports;
	private Lock lock;
	private Condition condition;

	public Producer(Queue<Report> reports, Lock lock, Condition condition) {
		this.reports = reports;
		this.lock = lock;
		this.condition = condition;
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
		lock.lock();
		while (reports.size() == MAX_REPORTS) {
			System.out.println("In producer, waiting...");
			condition.await();
		}

		Thread.sleep(PRODUCING_TIME);
		reports.add(new Report());
		System.out.println(Thread.currentThread().getName() + " is producing data with id " + Report.getCounter());

		// let consumer know that there is already 1 element in queue to consume
		if (reports.size() == 1)
			condition.signal();
		lock.unlock();
	}

}
