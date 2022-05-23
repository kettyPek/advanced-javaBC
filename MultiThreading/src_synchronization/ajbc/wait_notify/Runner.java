package ajbc.wait_notify;

import java.util.LinkedList;
import java.util.Queue;

public class Runner {
	
	public static void main(String[] args) {
		
		Queue<Report> queue = new LinkedList<>();

		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));

		producer.start();
		consumer.start();
	}

}
