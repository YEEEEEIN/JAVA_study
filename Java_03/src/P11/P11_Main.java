package P11;

import java.util.Scanner;

public class P11_Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final float current = 1308.00f;
		float currentedMoney;
		
		System.out.println("1. South Korean won -> United States Dollar");
		System.out.println("2. United States Dollar -> South Korean won");
		System.out.println("3.");
		int input = scanner.nextInt();
		int money = scanner.nextInt();

		if (input == 1) {
			currentedMoney = money / current;
			System.out.println(currentedMoney);
		} else if (input == 2) {
			currentedMoney = money * current;
			System.out.println(currentedMoney);
		} else {
			System.out.println("retry!");
		}
		
	}

}
