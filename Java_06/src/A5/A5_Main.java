package A5;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Printing Numbers Matching the Condition
-Initialize an integer array
-Print the numbers with N in each digit
-Add exception statements

[Code]
int[] numbers = {123, 32, 356, 53, 2, 67, 31, 78, 41, 9, 29};

[Example]
5
356 53

2
123 32 2 29
 */

public class A5_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = { 123, 32, 356, 53, 2, 67, 31, 78, 41, 9, 29 };
		System.out.println("찾으려는 숫자를 입력하세요.(0 ~ 9)");
		int matchNum;
		while (true) {
			try {
				matchNum = sc.nextInt();
				if (matchNum < 0 || matchNum > 9) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (InputMismatchException e) { // 입력값의 형식이나 타입이 맞지 않는 경우 발생
				System.out.println("숫자를 입력하세요.");
				sc.nextLine();
			} catch (IllegalArgumentException e) { // 메소드가 받은 인자가 유효하지 않은 경우
				System.out.println("0부터 9까지의 숫자를 입력하세요.");
				sc.nextLine();
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			String numStr = Integer.toString(numbers[i]);
			if (numStr.contains(Integer.toString(matchNum))) {
				System.out.print(numbers[i] + " ");
			}
		}

	}

}
