package Java_02;

import java.util.Scanner;

public class A07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int a = 0, b = 0, G = 0, L = 0;

		if (A != 0 && B != 0) {
			for (int i = 1; i <= A; i++) {
				if (A % i == 0) {
					a = i;
					for (int j = 1; j <= B; j++) {
						if (B % j == 0) {
							b = j;
						}
						if (a == b) {
							G = a;
						}
					}
				}

			}
			System.out.println("최대공약수는: " + G);

			L = A / G * B;
			System.out.println("최소공배수는: " + L);

		}

	}

}
