package A06;

import java.util.Scanner;

/*
 Compose a program with the conditions below
- Use your smartphone and compose the program on the web
- Compose a program counting the number of consonants and vowels
- This program should operate dynamically according to the user’s input string

This is an apple
Num. of Consonant : 8 // 자음
Num. of Vowels : 5 // 모음 a, e, i, o, u

I am fine
Num. of Consonant : 3
Num. of Vowels : 4

 */

public class A6_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		String inputLower = input.toLowerCase();

		int cntVowels = 0;
		int cntConsonant = 0;

		for (int i = 0; i < inputLower.length(); i++) {
			char c = inputLower.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				cntVowels++;
			} else if (c == ' ') {

			} else {
				cntConsonant++;
			}
		}
		System.out.println("Num. of Consonant : " + cntConsonant);
		System.out.println("Num. of Vowels : " + cntVowels);

	}

}
