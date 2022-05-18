package ajbc.multiThreading.create;

public class Ex3 {

	static int num = 1;
	static final int MULTIPLU_NUM_BY = 2;
	static final int SLEEP_MS = 100;
	static final int INTERRRUPT_MS = 2000;

	public static void main(String[] args) throws InterruptedException {

		ThreadGroup group = new ThreadGroup("my group");

		Thread thread1 = new Thread(group, new CustomThread());
		Thread thread2 = new Thread(group, new CustomThread());
		Thread thread3 = new Thread(group, new CustomThread());

		thread1.start();
		thread2.start();
		thread3.start();

		Thread.sleep(INTERRRUPT_MS);
		group.interrupt();

	}

	static class CustomThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(100);
					num *= MULTIPLU_NUM_BY;
					System.out.println("Thread name: " + Thread.currentThread().getName() + ", num is: " + num);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

}
