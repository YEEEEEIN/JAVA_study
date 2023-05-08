package P14;
/*
Article before Consonant and Vowel
-User inputs a sentence including at least an article
-Check if the articles before consonants and vowels are correct
-Modify the article if needed

This is a apple.
This is an apple.

This is a school.
This is a school.
*/

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class P14_Main { // 식이 별로 + A apple 인 경우도 못함(대소문자 구별 불가)

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();

		// String text = "This is a apple";
		// String text = "This is an banana";
		
		// a -> an || an -> a
		if (text.contains(" a a") || text.contains(" a e") || text.contains(" a i") || text.contains(" a o")
				|| text.contains(" a u") || text.contains("A a") || text.contains("A e") || text.contains("A e")
				|| text.contains("A ㅇ") || text.contains("A u")) {

			System.out.println(text);
			System.out.println(text.replace(" a ", " an ")); // 대체	
		} else if (!(text.contains(" an a") || text.contains(" an e") || text.contains(" an i")
				|| text.contains(" an o") || text.contains(" an u") || text.contains("An a") || text.contains("An e")
				|| text.contains("An i") || text.contains("An ㅇ") || text.contains("An u"))) {
			System.out.println(text);
			System.out.println(text.replace(" an ", " a "));
		}

		// An -> A || A -> An
		if (text.contains("A a") || text.contains("A e") || text.contains("A e") || text.contains("A ㅇ")
				|| text.contains("A u")) {

			System.out.println(text);
			System.out.println(text.replace(" A ", " An ")); // 대체
		} else if (!(text.contains("An a") || text.contains("An e") || text.contains("An i") || text.contains("An ㅇ")
				|| text.contains("An u"))) {
			System.out.println(text);
			System.out.println(text.replace(" An ", " A "));
		}

	}

}

//char[] c = text.toCharArray(); // 문자열을 char형 배열로 바꿔줌
// System.out.println(c[0]);
