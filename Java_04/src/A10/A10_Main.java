package A10;
/*
Comparing the two strings
- User inputs the two strings
- Show the result if those two strings are the same after relocation

[Example]
abcdefg
fgdceba
Yes

abcdbfg
Bbbcfda
No

Abc
cbA
Yes
 */

public class A10_Main {

	public static void main(String[] args) {
		String input1 = "Abc"; // a97 a122
		String input2 = "cba";

		int cntFinal = 0;

		for (int i = 0; i < input1.length(); i++) {
			int cnt = 0;
			int duplication = 0;
			for (int j = 0; j < input1.length(); j++) { // input1에서 같은 문자가 있는지 확인
				if (input1.charAt(i) == input1.charAt(j)) {
					duplication++;
				}
			}

			for (int k = 0; k < input2.length(); k++) { // line에 word 단어 1개가 몇개 있는지 확인
				if (input1.charAt(i) == input2.charAt(k)) {
					cnt++;
				}
			}

			cntFinal += cnt / duplication;

		}

		if (cntFinal == input1.length()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
