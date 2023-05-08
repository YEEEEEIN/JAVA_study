package P15;

import java.util.Scanner;

/*
Calculator
-User inputs an equation
-Print the calculated result
-Hint, String.substring(), String.contains()

5*7.5
37.5

32/2
16 
 */

public class P15_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		if (input.contains("+")) {
			int OperaterLocation = input.indexOf("+");
			double num1 = Double.parseDouble(input.substring(0, OperaterLocation));
			double num2 = Double.parseDouble(input.substring(OperaterLocation + 1, input.length()));
			System.out.println(num1 + num2);
		} else if (input.contains("-")) {
			int OperaterLocation = input.indexOf("-");
			double num1 = Double.parseDouble(input.substring(0, OperaterLocation));
			double num2 = Double.parseDouble(input.substring(OperaterLocation + 1, input.length()));
			System.out.println(num1 + num2);
		}
		if (input.contains("*")) {
			int OperaterLocation = input.indexOf("*");
			double num1 = Double.parseDouble(input.substring(0, OperaterLocation));
			double num2 = Double.parseDouble(input.substring(OperaterLocation + 1, input.length()));
			System.out.println(num1 + num2);
		}
		if (input.contains("/")) {
			int OperaterLocation = input.indexOf("/");
			double num1 = Double.parseDouble(input.substring(0, OperaterLocation));
			double num2 = Double.parseDouble(input.substring(OperaterLocation + 1, input.length()));
			System.out.println(num1 + num2);
		}
	}
}
