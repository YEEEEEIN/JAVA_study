package A6;
/*
Fibonacci Numbers
-The formula for this is as below
  F0 = 0, F1 = 1
  Fn = Fn-1 + Fn-2
  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 …
-Use a list
-User inputs a number
-Print the number of elements from the Fibonacci Numbers
 */

import java.util.ArrayList;
import java.util.Scanner;

public class A6_Main {

	public static void main(String[] args) {
		ArrayList<Integer> fibo = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			if (i == 0) {
				fibo.add(i);
			} else if (i == 1) {
				fibo.add(i);
			} else {
				fibo.add(fibo.get(i - 2) + fibo.get(i - 1));
			}
		}
		System.out.println(fibo);

	}

}
