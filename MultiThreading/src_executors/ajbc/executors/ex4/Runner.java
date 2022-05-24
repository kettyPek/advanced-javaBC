package ajbc.executors.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) {

		final int THREADS_NUM = 4;
		int javaCounter = 0;

		ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUM);

		List<Future<Integer>> furures = new ArrayList<>();

		try {
			URL url = new URL("https://en.wikipedia.org/wiki/Java_(programming_language)");
			URLConnection urlConnection = url.openConnection();

			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line ;

			while ((line = reader.readLine()) != null) {
				String lineTocheck = line;
				furures.add(executorService.submit(()-> {
					int counter = 0;
					String [] words = lineTocheck.split(" ");
					for(var word: words)
						if(word.toLowerCase().equals("java"))
							counter++;
					return counter;
				}));
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(var future : furures)
			try {
				javaCounter += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		
		executorService.shutdown();
		
		System.out.println("There is: " + javaCounter);

	}

}
