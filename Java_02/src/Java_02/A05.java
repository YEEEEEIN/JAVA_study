package Java_02;

import java.util.Scanner;

public class A05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("what is the height?");
		int N = scanner.nextInt();

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			for (int j = 2 * N - 1; j > i * 2; j--) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

	}

}
