package ajbc.dinning_philosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	static final int NUM_PHILO = 5;
	static List<Lock> forks = new ArrayList<>();
	
	static class Philosophers implements Runnable{
		
		private Semaphore semaphore;
		private int id;
		
		public Philosophers(int id,Semaphore semaphore) {
			this.id = id;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			think();
			pickForks();
			eat();
			putForks();
		}

		private void putForks() {
			System.out.println("Putting down right fork of philosopher " + id);
			forks.get(id).unlock();
			System.out.println("Putting down left fork of philosopher " + id);
			forks.get((id+1)%NUM_PHILO).unlock();
			semaphore.release();
			
		}

		private void pickForks() {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Taking right fork of philosopher " + id);
			forks.get(id).lock();
			System.out.println("Taking left fork of philosopher " + id);
			forks.get((id+1)%NUM_PHILO).lock();
		}

		private void eat() {
			System.out.println("The food is yummy... said " + id);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

		private void think() {
			System.out.println("The world is ... said " + id);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(NUM_PHILO-1);
		
		for(int i=0; i<NUM_PHILO; i++) {
			forks.add(new ReentrantLock());
		}
		
		for(int i=0; i<NUM_PHILO; i++) {
			new Thread(new Philosophers(i,semaphore)).start();
		}
	}

}
