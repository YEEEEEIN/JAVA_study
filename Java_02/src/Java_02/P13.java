package Java_02;

import java.util.Scanner;

public class P13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int num1 = scanner.nextInt(); // 1부터 num1까지 합
		int num2 = scanner.nextInt(); // num2칸씩 띄고
		int sum = 0;

		for (int i = 1; i <= num1; i = i + num2) {
			sum = sum + i;
		}
		System.out.println(sum);

	}

}
