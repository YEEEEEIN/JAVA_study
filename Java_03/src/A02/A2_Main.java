package A02;

import java.util.Scanner;

public class A2_Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int count_p = 0; // 양수
		int count_n = 0; // 음수
		int count_o = 0; // 홀수
		int count_e = 0; // 짝수

		while (true) {
			int num = sc.nextInt();
			if (num > 0) {
				count_p++;
				if (num % 2 == 1) {
					count_o++;
				} else {
					count_e++;
				}

			} else if (num < 0) {
				count_n++;
				if (-1 * num % 2 == 1) {
					count_o++;
				} else {
					count_e++;
				}
			} else {
				System.out.println("retry!");
			}
			System.out.print("P - " + count_p + ", ");
			System.out.print("N - " + count_n + ", ");
			System.out.print("O - " + count_o + ", ");
			System.out.println("E - " + count_e + ", ");
			System.out.println("");
		}

	}

}
