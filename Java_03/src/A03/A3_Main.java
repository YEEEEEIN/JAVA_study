package A03;
/*
Compose a program with the conditions below
-Compose a program calculating the number of alphabets
-The string is declared as a variable, “I go to school”

C – 1
G - 1
H – 1
I – 1
L – 1
O – 4
S - 1
T - 1
*/

import java.util.Scanner;

public class A3_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner sc = new Scanner(System.in);
		// String text = sc.nextLine();
		String text = "I go to school";

		text = text.toUpperCase();
		// System.out.println(text);

		for (int i = 65; i <= 90; i++) { // A~Z
			int count = 0;
			for (int j = 0; j < text.length(); j++) {
				char a = text.charAt(j);
				if (i == (int) a) {
					count++;
				}

			}
			if (count > 0) {
				System.out.println((char) i + " - " + count);

			}

		}

	}

}
