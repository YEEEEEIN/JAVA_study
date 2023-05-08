package A01;
/*
Descriptive Statistics Calculation
- User inputs a number
- Prints the number of numbers, mean, maximum, minimum

5
Result : 1 - Mean 5, Max 5, Min 5

3
Result : 2 – Mean 4, Max 5, Min 3

1
Result : 3 – Mean 3, Max 5, Min 1
*/

import java.util.Scanner;

public class A1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int count = 0;
		int max = 0;
		int min = 0;
		int sum = 0;

		while (true) {
			int num = sc.nextInt();
			count++;
			if (count == 1) {
				max = num;
				min = num;
				sum = num;
			} else {
				max = Math.max(max, num); // math함수
				min = Math.min(min, num);
				sum = sum + num;
			}
			System.out.print("Result : " + count + " - ");
			System.out.print("Mean " + sum / count + ", ");
			System.out.print("Max " + max + ", ");
			System.out.println("Mean " + min);
			System.out.println("");

		}

	}

}
