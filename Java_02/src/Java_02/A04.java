package Java_02;

import java.util.Scanner;

public class A04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N;
		System.out.println("what is the height?");
		N = scanner.nextInt();

		for (int i = 0; i <= N; i++) {
			for (int j = i; j <= N - 1; j++) {
				System.out.print(" ");
			}

			for (int k = 0; k < (i * 2 - 1); k++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}

	}

}
