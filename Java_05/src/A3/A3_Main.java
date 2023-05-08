package A3;

import java.util.Scanner;

/*
 Encryption
-User inputs a string
-Print the encrypted string
-To encrypt the string, use an array to match characters one to one
(ex, original = {1, 2, 3}, encrypted = {a, b, c})
-Write a scenario and compose it

abcd
zyxw

 */

public class A3_Main {

	public static void main(String[] args) {
		String[] original = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String[] encrypted = { "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i",
				"h", "g", "f", "e", "d", "c", "b", "a" };

		Scanner sc = new Scanner(System.in);
		String src = sc.nextLine();
		String result = "";

		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i); // 문자열 쪼개기
			int index = (int) c; // a => 97

			result += encrypted[index - 97];
		}

		System.out.println(result);

	}

}
