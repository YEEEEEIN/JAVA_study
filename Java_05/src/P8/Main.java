package P8;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2, 33, 7, 5, 12, 34, 99, 25, 28, 53, 20};
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			System.out.print(" ");
		}
		System.out.println("");
		System.out.println("---------------------------------");
		//Arrays.sort(numbers, Collections.reverseOrder());
		// => Collections은 기본타입인 int, double, char, float 등은 사용이 불가
		
		// primitive Type을 Wrapper클래스로 박싱해주어야 reverseOrder 사용가능.
	    Integer[] ArrNumbers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
	    Arrays.sort(ArrNumbers, Collections.reverseOrder());
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			System.out.print(" ");
		}
	}

}
