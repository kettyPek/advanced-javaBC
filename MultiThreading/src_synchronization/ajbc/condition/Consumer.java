package ajbc.condition;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable{
	
	private final int CONSUMING_TIME = 500;
	private final Queue<Report> reports;
	private Lock lock;
	private Condition condition;

	public Consumer(Queue<Report> reports,Lock lock,Condition condition) {
		this.reports = reports;
		this.lock = lock;
		this.condition = condition;
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
		lock.lock();
		while (reports.isEmpty()) {
			System.out.println("Consumer is waiting...");
			condition.await();
		}

		Thread.sleep(CONSUMING_TIME);

		Report data = reports.remove();
		System.out.println("Consumed data: " + data);

		//let producer know that the consuming started
		if (reports.size() == 1) {
			condition.signal();
		}
		lock.unlock();

	}
}

