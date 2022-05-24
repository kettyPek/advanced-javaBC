package ajbc.executors.ex3;

public class MatrixMultiplication implements Runnable{

	private int row;
	private int col;
	private int [][] matA;
	private int [][] matB;
	private int [][] matC;
	
	public MatrixMultiplication(int row, int col, int[][] matA, int[][] matB, int[][] matC) {
		this.row = row;
		this.col = col;
		this.matA = matA;
		this.matB = matB;
		this.matC = matC;
	}



	@Override
	public void run() {
		for(int i=0; i<matA.length; i++)
			matC[row][col] += matA[row][i] * matB[i][col];
		
	}

}
