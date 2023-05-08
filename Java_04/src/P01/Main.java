package P01;

import java.util.Scanner;

public class Main {
	public static Fruits Apple;
	public static Fruits Strawberry;
	public static Fruits Grape;
	public static Fruits Watermelon;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initialization();

		while (true) {
			int num = showMenu();
			showInformation(num);
		}
	}

	public static void initialization() { 
		Apple = new Fruits(1000, "Apple");
		Strawberry = new Fruits(2000, "Strawberry");
		Grape = new Fruits(3000, "Grape");
		Watermelon = new Fruits(4000, "Watermelon");
	}

	public static int showMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Price");
		System.out.println("1. Apple");
		System.out.println("2. Strawberry");
		System.out.println("3. Grape");
		System.out.println("4. Watermelon");
		System.out.println("5. Exit");

		int num = sc.nextInt();
		return num;
	}

	public static void showInformation(int num) {
		if (num == 1) {
			System.out.println(Apple.getName() + ", " + Apple.getPrice());
		} else if (num == 2) {
			System.out.println(Strawberry.getName() + ", " + Strawberry.getPrice());
		} else if (num == 3) {
			System.out.println(Grape.getName() + ", " + Grape.getPrice());
		} else if (num == 4) {
			System.out.println(Watermelon.getName() + ", " + Watermelon.getPrice());
		} else if (num == 5) {
			System.out.println("Bye bye!");
		} else {
			System.out.println("Error");
		}
	}
}
