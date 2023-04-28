package Java_02;

import java.util.Scanner;

public class P07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 스캐너 환경 설정?

		int n;
		System.out.println("What number do you want?");

		n = scanner.nextInt();

		for (int i = 2; i <= 9; i++) {
			System.out.println(n + " X " + i + " = " + n * i);
		}

	}

}
