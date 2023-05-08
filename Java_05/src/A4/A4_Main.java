package A4;
/*
 Decryption
-Regarding as the previous practice, user inputs a string
-Print the decrypted string

zyxw
abcd
 */

import java.util.Scanner;

public class A4_Main {

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
			int index = (int) c; // z => 122

			result += original[122 - index];
		}

		System.out.println(result);

	}

}
