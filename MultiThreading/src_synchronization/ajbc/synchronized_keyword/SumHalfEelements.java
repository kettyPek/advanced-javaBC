package ajbc.synchronized_keyword;

import java.util.concurrent.locks.Lock;

public class SumHalfEelements implements Runnable {
	
	private EXE1 runner;
	final int SUM_FROM;
	final int SUM_TO;
	private Lock lock;
	
	public SumHalfEelements(int sumFrom, int sumTo, EXE1 runner, Lock lock) {
		this.SUM_FROM = sumFrom;
		this.SUM_TO = sumTo;
		this.runner = runner;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		lock.lock();
		for(int i=SUM_FROM; i<=SUM_TO; i++)
			runner.addToSum(runner.getList().get(i));
		lock.unlock();
	}

}
