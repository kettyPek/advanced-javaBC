package ajbc.executors.ex3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		final int MATRIX_DIMENTION = 10;
		
		int [][] matA = new int [MATRIX_DIMENTION][MATRIX_DIMENTION];
		int [][] matB = new int [MATRIX_DIMENTION][MATRIX_DIMENTION];
		
		for(int i=0; i<MATRIX_DIMENTION; i++)
			for(int j=0; j<MATRIX_DIMENTION; j++) {
				matA[i][j] = 1;
				matB[i][j] = 1;
			}
		long start = System.nanoTime();
		
		int [][] matC = matrixCalculation(matA,matB);
		long startSerial = System.nanoTime();
		System.out.println("Serial method: " + (startSerial -start));
		
//		System.out.println("Serial calculation : ");
//		printMatrix(matC);
		
		int [][] matD = new int [MATRIX_DIMENTION][MATRIX_DIMENTION];
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for(int i=0; i<MATRIX_DIMENTION; i++)
			for(int j=0; j<MATRIX_DIMENTION; j++)
				executorService.submit(new MatrixMultiplication(i,j,matA,matB,matD));
		
		long startThreads = System.nanoTime();
		System.out.println("Threads method: " + (startThreads-startSerial));
//		printMatrix(matD);
		
		executorService.shutdown();
		
	}
	
	static int [][] matrixCalculation(int [][] matA, int [][] matB){
		
		int matRows = matA.length;
		int matCols = matA[0].length;
		int [][] matC = new int [matRows][matCols];
		
		for(int i=0; i<matRows; i++)
			for(int j=0; j<matCols; j++)
				for(int k=0; k<matRows; k++)
					matC[i][j] += matA[i][k] * matB[k][j];
		return matC;
		}
	
	static void printMatrix(int [][] mat) {
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	

}
