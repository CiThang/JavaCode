package ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	public static final int NUM_OF_THREAD = 2;
	public static final int INITIAL_DELAY = 1; // second
	public static final int DELAY = 3; // second
	
	public static void main(String[] args) throws InterruptedException{
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_OF_THREAD);
		
		for(int i=1 ;i<=5; i++) {
			Runnable worker = new WorkerThread(""+i);
			executor.scheduleWithFixedDelay(worker, INITIAL_DELAY, DELAY, TimeUnit.SECONDS);
		}
		
		// Chi cho ket thuc trong 10s
		executor.awaitTermination(10, TimeUnit.SECONDS);
		
		executor.shutdown();
		
		// wait until all threads are finish
		while(!executor.isTerminated()) {
			//running....
		}
		System.out.println("Finished all threads");
	}
	
	/*Trong chương trình trên, tôi đã tạo ra ThreadPool có kích thước cố định là 2. Sau đó, tôi đã tạo 5 task (công việc) vào ThreadPool
	 * vì kích thước ThreadPool là 2, nên nó sẽ bắt đầu thực thi chương trình trên vói 5 task
	 * và các task khác sẽ ở trạng thái đợi (waiting), ngay khi một task hoàn thành, một task khác từ hàng đợi sẽ được chọn và thực thi.
	 * Các thread này được lên kế hoạch thực thi bằng phương thức scheduleWithFixedDelay(), sau khi thực thi lần đầu tiên, nó sẽ được gọi để thực thi lại sau khoảng thời gian delay xác định.
	 * 
	 *  Phương thức này gồm 4 tham số như sau:
	 *  Runnable: tác vụ sẽ được thực thi.
	 *  initialDelay: thời gian trì hoãn trước khi thực thi lần đầu tiên.
	 *  delay: thời gian trì hoãn kể từ khi thực thi lần trước đó kết thúc.
	 * TimeUnit: đơn vị thời gian của tham số initialDelay và delay.
	 * 
	 * 
	 * awaitTermination() - phương thức này xác định thời gian chờ tối đa để các task hoàn thành thực thi.
	 * 
	 * */
	
}
