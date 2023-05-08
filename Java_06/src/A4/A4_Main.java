package A4;

import java.util.Scanner;

/*
Finding a Character
- User inputs a string and a character
- Find the character from the string and show the order of the first found(case sensitive)
- Add exception statements

[Example]
South Korea has a earned a reputation as a leading global ICT center
s
15

South Korea has a earned a reputation as a leading global ICT center
S
1
 */

public class A4_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("문장을 입력하세요");
			String text = sc.nextLine();
			System.out.println("단어(한글자)를 입력하세요");
			char word = sc.next().charAt(0);

			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (word == c) {
					System.out.println(i + 1);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("입력에 문제가 있습니다.");
			e.printStackTrace();
		}
	}

}
