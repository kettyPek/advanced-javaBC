package ajbc.multiThreading.create;

public class Ex1 {

	static int num = 10;
	static final int LOOPS_AMOUNT = 3;
	static final int NUM_CHANGER = 2;
	
	public static void main(String[] args) throws InterruptedException {
		
		CustomThread thread1 = new CustomThread();
		
		Runnable customRunnable = new Runnable() {
			@Override
			public void run(){
				for(int i=0; i<LOOPS_AMOUNT; i++) {
					System.out.println(Thread.currentThread().getName());
					num += NUM_CHANGER;
				}
			}
		};
		Thread thread2 = new Thread(customRunnable);
		Thread thread3 = new Thread(()->{
			for(int i=0; i<LOOPS_AMOUNT; i++) {
				System.out.println(Thread.currentThread().getName());
				num /=NUM_CHANGER;
			}
		});
		
		thread1.setPriority(2);
		thread2.setPriority(3);
		thread3.setPriority(1);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		
		System.out.println("num is: " + num);
		
	}
	
	static class CustomThread extends Thread{
		@Override
		public void run() {
			for(int i=0; i<LOOPS_AMOUNT; i++) {
				System.out.println(Thread.currentThread().getName());
				num *= NUM_CHANGER;
			}
		}
	}

}
