package ajbc.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	public static void main(String[] args) {
		
		Queue<Report> queue = new LinkedList<>();
		
		Lock lock = new ReentrantLock();
	    Condition condition = lock.newCondition();

		Thread producer = new Thread(new Producer(queue,lock,condition));
		Thread consumer = new Thread(new Consumer(queue,lock,condition));

		producer.start();
		consumer.start();
	}

}
