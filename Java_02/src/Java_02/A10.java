package Java_02;

import java.util.Scanner;

public class A10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int coke = 340;
		int orangeJuice = 500;
		int milk = 650;
		int water = 290;
		int coffee = 170;

		int choice = scanner.nextInt();
		int price = 0, change, change1, won100, won50, won10;

		if (choice == 1) {
			price = coke;
		} else if (choice == 2) {
			price = orangeJuice;
		} else if (choice == 3) {
			price = milk;
		} else if (choice == 4) {
			price = water;
		} else if (choice == 5) {
			price = coffee;
		}

		change = 1000 - price; // 350

		won100 = change / 100; // 3
		change1 = change % 100; // 50
		won50 = change1 / 50; // 1
		change1 = change1 % 50; // 0
		won10 = change1 / 10; // 0

		System.out
				.println("The change is " + change + "(100 X " + won100 + ", 50 X " + won50 + ", 10 X " + won10 + ")");

	}

}
