package Practice;

public class Thread_05 implements Runnable {

	public static void main(String[] args) {
		Thread_05 main = new Thread_05();
		Thread thread = new Thread(main);
		thread.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Tread");
	}

}
