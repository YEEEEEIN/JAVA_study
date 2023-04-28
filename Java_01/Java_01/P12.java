package Java_01;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input1st, input2nd, result = 0;

		System.out.println("Input the 1st number!");
		input1st = scanner.nextInt();

		System.out.println("Input the 2nd number!");
		input2nd = scanner.nextInt();

		result = input1st + input2nd;
		System.out.println("Result : " + input1st + "+" + input2nd + "=" + result);

	}

}
