package ajbc.pools_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {

	public static void main(String[] args) {
		
		final int CORE_THREADS = 5;
		final int MAX_POOL_SIZE = 6;
		final long KEEP_ALIVE_TIME = 3;
		final int CAPACITY = 5;
		
		final BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(CAPACITY);
		RejectedExecutionHandler handler = (Runnable runnable,ThreadPoolExecutor t)->{
			System.out.println("Default task rejection handler");};
			
		ThreadPoolExecutor pool = new ThreadPoolExecutor(CORE_THREADS, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, tasks,handler);

		File file = new File("MyFiles/Alice.txt");
		
		String[] wordsInLIne;
		Map<String,Integer> words = new HashMap<String,Integer>();

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				wordsInLIne = line.replaceAll("[\":;,.(!?'`-]", "").split(" ");
				pool.execute(new SeparateWordsToMap(words,wordsInLIne));
			}
			sc.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
		pool.shutdown();

		words.entrySet().stream().forEach(System.out::println);
	}
	
	

}
