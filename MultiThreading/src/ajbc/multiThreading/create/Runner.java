package ajbc.multiThreading.create;

public class Runner {

	static int myVar = 123;
	
	public static void main(String[] args) throws InterruptedException {
		//get current thread
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		
		//creating thread using extension
		//option 1:
		PrinterThread thread1 = new PrinterThread();
		thread1.start(); //forking the thread
		//option 2:
		Thread thread2 = new Thread(new PrinterThread());
		thread2.start();
//		System.out.println(thread.getName());//will be executed before the forked thread
		thread2.join();//main thread will wait until thread2 finish its action
		System.out.println(thread.getName());
		
		//creating thread using runnable interface
		Runnable myRunnable = new Runnable() {
			@Override
			public void run(){
				for(int i=0;i<5 ;i++)
					System.out.println("Java");
				
			}
		};
		Thread thread3 = new Thread(myRunnable);
		thread3.start();
		
		//creating thread using functional interface
		Thread thread4 = new Thread(()->{
			for(int i=0;i<4;i++)
				System.out.println("hello from " + Thread.currentThread().getName());
		},"thread4");
		thread4.start();

	}
	
	//

	static class PrinterThread extends Thread{
		@Override
		public void run() {
			try {
				Thread.sleep(2000);//on current thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello from " + Thread.currentThread().getName());
		}
	}
}
