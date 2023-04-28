package Java_02;

import java.util.Scanner;

public class P06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int cal, input1, input2, result = 0;

		System.out.println("1. +\n");
		System.out.println("2. -\n");
		System.out.println("3. *\n");
		System.out.println("4. /\n");
		System.out.println("--->");

		cal = scanner.nextInt();
		input1 = scanner.nextInt();
		input2 = scanner.nextInt();

		if (cal == 1) {
			result = input1 + input2;
		} else if (cal == 2) {
			result = input1 - input2;
		} else if (cal == 3) {
			result = input1 * input2;
		} else if (cal == 4) {
			result = input1 / input2;
		} else {
			System.out.println("잘못 입력했습니다!");
		}

		System.out.println(result);

	}

}
