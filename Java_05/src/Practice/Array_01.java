package Practice;

public class Array_01 {

	public static void main(String[] args) {
		int[] numbers = new int[10]; // 배열 껍데기 생성
		String[] name = { "Kim", "Lee", "Park" };

		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

		try { // try catch
			for (int i = 0; i < name.length; i++) {
				System.out.println(name[i]);
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

}
