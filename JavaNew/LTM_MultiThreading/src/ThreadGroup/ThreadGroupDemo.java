package ThreadGroup;

public class ThreadGroupDemo implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		ThreadGroupDemo runnable = new ThreadGroupDemo();
		ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");
		
		Thread t1 = new Thread(tg1, runnable, "one");
		t1.start();
		Thread t2 = new Thread(tg1, runnable, "two");
		t2.start();
		Thread t3 = new Thread(tg1, runnable, "three");
		t3.start();
	
		System.out.println("Thread Group Name: "+tg1.getName());
		tg1.list();
		System.out.println("Ten nhom thread"+tg1.getName());
	
	}
	//int activeCount(): 		Trả về số thread đang chạy trong nhóm hiện tại.
	//int activeGroupCount(): 	Trả về số nhóm thread active trong nhóm thread hiện tại.
	//void destroy(): 			Phá hủy nhóm thread này và tất cả các nhóm con của nó.
	//String getName(): 		Trả về tên của nhóm thread này.
	//ThreadGroup getParent(): 	Trả về nhóm cha của nhóm thread này.
	//void interrupt():			Ngắt tất cả các thread trong nhóm này.
	//void list(): 				In thông tin của nhóm này lên màn hình console.
	
}
