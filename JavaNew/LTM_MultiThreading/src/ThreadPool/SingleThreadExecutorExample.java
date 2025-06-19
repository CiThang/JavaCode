package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {

	public static void main(String[] args) {
		ExecutorService executor =  Executors.newSingleThreadExecutor();
		
		for(int i=1; i<=10; i++) {
			Runnable worker = new WorkerThread(""+i);
			executor.execute(worker);
		}
		executor.shutdown();
		
		// Doi cho den khi tat ca cac thread ket thuc 
		while(!executor.isTerminated()) {
			// Runnin....
		}
		
		System.out.println("Finished all threads");
	}
}
