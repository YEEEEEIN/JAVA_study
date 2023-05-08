package A08;

import java.util.Scanner;

/*
 Encoding and Decoding Program
- Prints a menu 
- User chooses the menu 
- The encoder and decoder follow the rules below. 

0123456789 // '0' => 48         +97-48
abcdefghij // 'a' => 97

#Menu
Encoder // 암호기: 번호 -> 알파벳
Decoder // 해독기: 알파벳 -> 번호
Exit
1
01012345678
ababcdefghi // a-97
2
add // 97
033
 */

public class A8_Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = showMenu();
		if (choice == 1) {
			encoding();
		} else if (choice == 2) {
			decoding();
		}

	}

	public static int showMenu() {
		System.out.println("#Menu");
		System.out.println("1. Encoder");
		System.out.println("2. Decoder");
		System.out.println("3. Exit");

		Scanner sc = new Scanner(System.in);

		return sc.nextInt();

	}

	public static void encoding() { // 숫자 -> 알파벳
		String text = sc.nextLine();
		for (int i = 0; i < text.length(); i++) {
			int a = (int) text.charAt(i);
			System.out.print((char) (a + 49));
		}

	}

	public static void decoding() { // 알파벳 -> 숫자 add->033
		String text = sc.nextLine();
		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);
			System.out.print((int) (a - 97));
		}

	}

}
