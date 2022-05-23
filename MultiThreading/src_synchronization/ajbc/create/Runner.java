package ajbc.create;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	static int counter = 0;
	static final int LOOPS = 1000;
	static final Object synchronizer = new Object();
	public static Runner runner = new Runner();
	
	public synchronized void incrementCounter() {
		counter++;
	}
	
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		ThreadGroup group = new ThreadGroup("Group1");
		for (int i = 0; i < LOOPS; i++) {
			Thread thread = new Thread(group,new MyRunnable());
			thread.start();
			threads.add(thread);
		}
		
		group.interrupt();
		
		threads.forEach(x -> {
			try {
				x.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println("Total is : " + counter);

	}
	
	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			
			// Synchronized Block
//			synchronized(synchronizer) {
//			counter ++;	
//			}
			
			// Synchronized method
			runner.incrementCounter();
		}
	}

}
