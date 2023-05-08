package Practice;

public class Practice_30 { // Overloading

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("hello?");
		print(1, 3);

	}

	public static void print(String text) { // void -> return 없음
		System.out.println(text);
	}

	public static void print(int a, int b) {
		int sum = a + b;
		System.out.println(sum);
	}

}
