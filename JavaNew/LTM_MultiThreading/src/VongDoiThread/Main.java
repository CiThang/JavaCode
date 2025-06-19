package VongDoiThread;

public class Main implements Runnable{
	public static Thread thread1;
    public static Main obj;

    public static void main(String[] args) {
        obj = new Main();
        Thread hread1 = new Thread(obj);

        System.out.println("Trạng thái của thread1 sau khi tạo - " + thread1.getState());

        thread1.start();

        System.out.println("Trạng thái của thread1 sau khi gọi start() - " +
                thread1.getState());
    }

    public void run() {
        MyThread myThread = new MyThread();
        Thread thread2 = new Thread(myThread);

        System.out.println("Trạng thái của thread2 sau khi tạo - " + thread2.getState());

        thread2.start();

        System.out.println("Trạng thái của thread2 sau khi gọi start() - " +
                thread2.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Trạng thái của thread2 sau khi gọi sleep() - " +
                thread2.getState());

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Trạng thái của thread2 sau khi kết thúc - " +
                thread2.getState());
    }
}
