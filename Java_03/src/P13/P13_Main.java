package P13;

/*
 Extracting Word from String
-User inputs one sentence and one word
-Calculate how many input words can be made from the sentence
-No need to change the font color as below, it just helps you understand

I go to school by subway but it takes a very long time to go to school.
cool
2

 */
import java.util.Scanner;

public class P13_Main {

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
