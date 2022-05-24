package ajbc.forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Runner {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		final int ARRAY_SIZE = 5;
		Double [] array = new Double[ARRAY_SIZE];

		for (int i = 0; i <ARRAY_SIZE; i++)
			array[i] = 1.0 + i;

		ForkJoinPool pool = new ForkJoinPool(2);

		pool.execute(new SummationTask(0,ARRAY_SIZE,array));

		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("The array is: " + SummationTask.getSum());
	}

}
