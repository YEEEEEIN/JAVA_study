package A9;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Descriptive Statistics Calculation
-User inputs a number, and assign it to a list // 모든 정수 실수 가능
-Prints the number of numbers, mean, maximum, minimum
-This is performed indefinitely
-Add exception statements

5
Result : 1 - Mean 5, Max 5, Min 5

3
Result : 2 – Mean 4, Max 5, Min 3

1
Result : 3 – Mean 3, Max 5, Min 1

 */

public class A9_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE; // Java에서 정수의 최소값
		int min = Integer.MAX_VALUE; // Java에서 정수의 최대값
		double mean = 0;

		while (true) {
			try {
				int n = sc.nextInt();
				cnt++;
				sum += n;
				mean = sum / cnt;
				max = Math.max(max, n);
				min = Math.min(min, n);
				// 출력
				System.out.print("Result : " + cnt + " - ");
				System.out.print("Mean " + cnt + ", ");
				System.out.print("Max " + max + ", ");
				System.out.println("Min " + min);
			} catch (InputMismatchException e) {
				System.out.println("다시 입력하세요.");
				// sc.nextLine()은 InputMismatchException이 발생하면 
				// 입력 버퍼에 남아있는 잘못된 입력 값을 버리고, 입력스트림을 초기화하는 역할
				sc.nextLine();

			}

		}

	}

}
