package ajbc.pools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {
	
	
	private static final int CORE_THREADS = 3;
	private static final int MAX_POOL_SIZE = 4;
	private static final long KEEP_ALIVE_TIME = 3;
	private static final int CAPACITY = 2;
	
	private static final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY);
	private static RejectedExecutionHandler handler = (Runnable runnable,ThreadPoolExecutor t)->{
		System.out.println("Default task rejection handler");};
	
	public static void main(String[] args) {
		
		// Unhandled exception
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, tasks);
		
		// try-catch wrap
		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, tasks,handler);
		
		
		
		for(int i=0; i<10 ;i++) {
			pool.execute(()-> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("JAVA THREAD");});
			
			System.out.println(pool.getPoolSize());
		}	
		
		
		Callable<Integer> myCallable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(1000);
				return 4;
			}	
		};
		
		Future<Integer> future = pool.submit(myCallable);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pool.shutdown();
	}

}
