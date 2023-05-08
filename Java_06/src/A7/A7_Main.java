package A7;
/*
Fibonacci Numbers
-The formula for this is as below
  F0 = 0, F1 = 1
  Fn = Fn-1 + Fn-2
  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 …
-Use a list
-User inputs a number
-Print the number of elements from the Fibonacci Numbers
-Add exception statements

7
0 1 1 2 3 5 8
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A7_Main {

	public static void main(String[] args) {
		ArrayList<Integer> fibo = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int inputNum;
		// try-catch
		try {
			inputNum = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error");
			return; // return 해줘야 에러가 안났을 때 for 구문으로 넘어감
		}
		
		// 피보나치 수열 생성
		for (int i = 0; i < inputNum; i++) {
			if (i == 0) {
				fibo.add(0);
			} else if (i == 1) {
				fibo.add(1);
			} else
				fibo.add(fibo.get(i - 2) + fibo.get(i - 1));
		}
		
		// 피보나치 수열 출력
		System.out.println(fibo);

	}

}
