package A05;
/* 
Data Confirmation
-Set up your conditions
-The number of conditions should be at least 5

e.g.,
  #1 : The string length should be over 10
  #2 : The string should contains the character ‘k’
  ….

-> abdefewqqwer
FAIL
-> kdefkdie123
PASS
*/

import java.util.Scanner;

public class A5_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("-> ");
		String input = sc.nextLine();

		if (input.length() > 10 && input.contains("k")) {
			System.out.println("PASS");

		} else {
			System.out.println("FAIL");
		}

	}

}
