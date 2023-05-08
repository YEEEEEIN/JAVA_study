package A6;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Compose a program with the conditions below
-User inputs the numbers N and M
-Print all the cases made by the combination of 1 to N and 1 to M // N, M >= 1
-Add exception statements

->
2
3
1,1
1,2
1,3
2,1
2,2
2,3
 */

public class A6_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int m = 0;
		System.out.println("정수 N, M을 입력하세요. (N, M은 1이상)");
		// n 오류 검사
		while (true) {
			try {
				System.out.print("N => ");
				n = sc.nextInt();
				if (n < 1) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) { // 입력값의 형식이나 타입이 맞지 않는 경우
				System.out.println("정수 값을 입력해주세요.");
				sc.nextLine();
			} catch (IllegalArgumentException e) { // 메소드가 받은 인자가 유효하지 않은 경우
				System.out.println("1이상의 숫자를 입력해주세요.");
				sc.nextLine();
			}
		}
		// m 오류 검사
		while (true) {
			try {
				System.out.print("M => ");
				m = sc.nextInt();
				if (m < 1) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) { // 입력값의 형식이나 타입이 맞지 않는 경우
				System.out.println("정수 값을 입력해주세요.");
				sc.nextLine();
			} catch (IllegalArgumentException e) { // 메소드가 받은 인자가 유효하지 않은 경우
				System.out.println("1이상의 숫자를 입력해주세요.");
				sc.nextLine();
			}
		}
		// 결과 값 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println((i + 1) + "," + (j + 1));
			}
		}
	}

}
