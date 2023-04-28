package Java_02;

import java.util.Scanner;

public class A03 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int N, i;
		System.out.println("what is the height?");
		N = scanner.nextInt();
		
		for (i = 0; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
		System.out.println(" ");
		}

	}

}
