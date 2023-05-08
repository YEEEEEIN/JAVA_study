package A2; // 정원 언니 코드

import java.util.Scanner;

/*
Counting a Specified Character
-User inputs a string and assign it into an array
-User inputs a word and assign it into an array
-Count how many are the input words included in the string

I go to school. Where are you going?
o
6

I go to school. Where are you going?
go
3

 */

public class A2_Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine(); // I go to school. Where are you going?
		String word = scanner.nextLine(); // go

		int min = 999;

		for (int i = 0; i < word.length(); i++) {
			int cnt = 0;
			int cntFinal = 0;
			int duplication = 0;
			for (int j = 0; j < word.length(); j++) { // word에서 같은 문자가 있는지 확인
				if (word.charAt(i) == word.charAt(j)) {
					duplication++;
				}
			}

			for (int h = 0; h < line.length(); h++) { // line에 word 단어 1개가 몇개 있는지 확인
				if (word.charAt(i) == line.charAt(h)) {
					cnt++;
				}
			}

			cntFinal = cnt / duplication;

			if (cntFinal < min) {
				min = cntFinal;

			}
		}
		System.out.println(min);
	}
}
