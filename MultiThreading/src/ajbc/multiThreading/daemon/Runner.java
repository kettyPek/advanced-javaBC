package ajbc.multiThreading.daemon;

public class Runner {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new SleeperRunnable(10),"sleeping beauty thread");
		Thread thread2 = new Thread(new SleeperRunnable(5),"prince charming thread");
		
		thread1.setDaemon(true);
		thread1.start();
		thread2.start();
	}
	
	static class SleeperRunnable implements Runnable{

		private final int NUM_SECONDS;
		
		public SleeperRunnable(int numSeconds) {
			super();
			NUM_SECONDS = numSeconds;
		}

		@Override
		public void run() {
			for(int i=0; i<NUM_SECONDS; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + " is slepping for 1 sec");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}

}
