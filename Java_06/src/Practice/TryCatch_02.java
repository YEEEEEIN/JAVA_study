package Practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		try {
			a = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error");
			a = sc.nextInt();
		}
		System.out.println(a);
	}

}
