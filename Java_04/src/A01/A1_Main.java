package A01;
/*
Program to Calculate the Probabilities
-User inputs the numbers N and M
-Print all the cases when the sum is M when throwing N of dice 

2
6
(1, 5)
(2, 4)
(3, 3)
(4, 2)
(5, 1)
*/

import java.util.Scanner;

public class A1_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 주사위 개수
		int m = sc.nextInt(); // 주사위 합

		rollDice(n, m, ""); // rollDice(남은 주사위의 개수, 남은 주사위의 합, 여태 나온 주사위의 값) => 제로섬 게임
	}

	// 주사위를 n번 던져서 합이 sum이 되는 경우의 수를 출력하는 함수
	public static void rollDice(int n, int sum, String result) {
//	        if (n == 0) { // 주사위를 n번 던졌을 때
//	            if (sum == 0) { // 합이 sum이 되는 경우
//	                System.out.println(result);
//	            }
//	        } else { // 주사위를 더 던질 필요가 있을 때
//	            for (int i = 1; i <= 6; i++) {
//	                rollDice(n-1, sum-i, result + i + " ");
//	            }
//	        }

		// 해석하기 쉽게 직관적으로
		if (n > 0) { // 주사위를 더 던질 필요가 있을 때
			for (int i = 1; i <= 6; i++) { // 주사위 사용
				rollDice(n - 1, sum - i, result + i + " "); // 문자열과 숫자를 더하면, 숫자가 문자열로 변환되어 문자열과 결합됩
			}
		} else { // 주사위 다 사용했을 때
			if (sum == 0) { // 합이 sum이 되는 경우
				System.out.println(result);
			}
		}

	}

}





/*
public class A1_Main {

	static int N; // 주사위 개수
	static int M; // 주사위 합
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 주사위갯수 2
		M = sc.nextInt();// 구하고 싶은 합 4
		arr = new int[N];
		dice(0, 0);

	}

	public static void dice(int level, int sum) {
		if (level < N) {
			for (int i = 1; i <= 6; i++) {
				arr[level] = i;
				dice(level + 1, sum + i);
			}
		} else {
			if (sum == M) {
				for (int j = 0; j < N; j++) { // 0번~N-1번째 주사위 값
					System.out.print(arr[j] + " ");
				}
				System.out.println("");
			}
		}
	}
}
*/