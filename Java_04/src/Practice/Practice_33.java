//package Practice;
//
//public class Practice_33 { // Recursive Function
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		for (int i = 1; i <= 10; i++) {
//			System.out.println(sumToOne(i));
//		}
//
//	}
//
//	public static int sumToOne(int number) {
//		if (number == 1) {
//			return 1;
//		} else {
//			return number + sumToOne(--number);
//		}
//	}
//
//}





package Practice;

import java.util.Scanner;

public class Practice_33 { // 입력받은 값 ~ 10까지 합 출력

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(sumToTen(n));
			break;
		}
	}

	public static int sumToTen(int number) {
		if (number > 10) {
			return 0;
		} else {
			return number + sumToTen(++number);
		}
	}
}
