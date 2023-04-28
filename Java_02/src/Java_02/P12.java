package Java_02;

import java.util.Scanner;

public class P12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = 0, sum = 0;
		n = scanner.nextInt();

		for (int i = 0; i <= n; i++) {
			sum = sum + i;
		}

		System.out.println(sum);

	}

}
