package ajbc.forkjoinpool;

import java.util.concurrent.RecursiveAction;

public class SummationTask extends RecursiveAction {

	private final int left;
	private final int right;
	private final Double [] array;
	private static double sum;

	static {
		sum = 0.0;
	}
	public SummationTask(int left, int right ,Double [] array) {
		this.left = left;
		this.right = right;
		this.array = array;
	}

	@Override
	protected void compute() {
		if (right - left == 0) 
			sum += array[left];
		else {
			int mid = (left + right) / 2;
			invokeAll(new SummationTask(left, mid,array), new SummationTask(mid+1, right,array));
		}
	}
	
	public static double getSum() {
		return sum;
	}

}
