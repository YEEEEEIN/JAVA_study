package Practice;

public class TryCatch_01 {

	public static void main(String[] args) {
		int[] numbers = { 5, 10, 12 };

		try {
			System.out.println(numbers[3]);
		} catch (Exception e) {
			System.out.println("exception");
			// e.printStackTrace();
		} finally {
			System.out.println("finally");
		}

	}

}


/*
package Practice;

public class TryCatch_01 {

	public static void main(String[] args) {
		int[] numbers = { 5, 10, 12 };

		try {
			System.out.println(numbers[3]);
		} catch (Exception e) {
			System.out.println("exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}

	}

}
*/