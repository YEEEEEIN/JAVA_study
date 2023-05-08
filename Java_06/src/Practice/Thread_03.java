package Practice; // setPriority()

public class Thread_03 {

	public static void main(String[] args) {
		

	}

}

class MultiThreadTest extends Thread {
	public MultiThreadTest (String threadName) {
		this.setName(threadName);
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " Thread_Start");
	}
}
