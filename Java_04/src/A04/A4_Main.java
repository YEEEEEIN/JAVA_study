package A04; // Decryption => Error

import java.util.Scanner;

/*
Encryption and Decryption
- Create your own encryption algorithm
- e.g., a->b, b->c, c->d, d->e

#Menu
1. Encryption // 암호화
2. Decryption // 복호화
-> school
Result : tdippm

1.  Encryption
2.  Decryption
-> tdippm
Result : school


 */

public class A4_Main {

	public static void main(String[] args) {
		int choice = showMenu();

		if (choice == 1) {
			String text1 = inputText();
			Encryption(text1);
		} else if (choice == 2) {
			String text2 = inputText();
			Decryption(text2);
		}

	}

	public static int showMenu() {
		System.out.println("#Menu");
		System.out.println("1. Encryption");
		System.out.println("2. Decryption");

		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;

	}

	public static String inputText() {
		Scanner sc = new Scanner(System.in);
		String inputText = sc.nextLine();
		return inputText;
	}

	public static void Encryption(String text) {
		System.out.print("Result : ");
		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);
			int b = (int) a + 1;
			System.out.print((char) b);
		}

	}

	public static void Decryption(String text) {
		System.out.print("Result : ");
		for (int i = 0; i < text.length(); i++) {
			char a = text.charAt(i);
			int b = (int) a - 1;
			System.out.print((char) b);
		}

	}

}
