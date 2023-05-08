package A03;
/* 
Program to Calculate the Sum of Multiples of N
- User inputs the two numbers for the M and N respectively
- Calculate the sum of multiples of N from 1 to M

20
5
SUM : 50(5, 10, 15, 20)
*/

import java.util.Scanner;

public class A3_Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;

		// SUM 출력
		for (int i = n; i <= m; i += n) {
			// System.out.print(i + ",");
			sum += i;
		}
		System.out.print("SUM : " + sum);

		// 20까지의 5의 배수 출력
		System.out.print("(");
		for (int i = n; i <= m; i += n) {
			if (i < m) {
				System.out.print(i + ", ");
			} else if (i == m) {
				System.out.print(m);
			}
		}
		System.out.print(")");

	}

}
