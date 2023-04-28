package Java_02;

import java.util.Scanner;

public class P03 {

	public static void main(String[] args) {
		// 거스름돈

		Scanner scanner = new Scanner(System.in);

		int input1, input2, change;

		input1 = scanner.nextInt(); // 낸 돈
		input2 = scanner.nextInt(); // 물건 값
		change = input1 - input2; // 거스름돈

		System.out.println(change);
		System.out.println("10000 - " + change / 10000);
		change = change % 10000;
		System.out.println("5000 - " + change / 5000);
		change = change % 5000;
		System.out.println("1000 - " + change / 1000);
		change = change % 1000;
		System.out.println("500 - " + change / 500);
		change = change % 500;
		System.out.println("100 - " + change / 100);
		change = change % 100;
		System.out.println("50 - " + change / 50);
		change = change % 50;
		System.out.println("10 - " + change / 10);

	}

}
