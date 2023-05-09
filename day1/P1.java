package day1;

import java.util.Arrays;

public class P1 {
	public char[] solution(int n, int[][] ladder) {
		char[] answer = new char[n];
		for (int i = 0; i < n; i++) {
			answer[i] = (char) (65 + i);
		}
		// System.out.println(answer);
		for (int i = 0; i < ladder.length; i++) {
			for (int j = 0; j < ladder[i].length; j++) {
				int a = ladder[i][j];
				char temp = answer[a - 1];
				answer[a - 1] = answer[a];
				answer[a] = temp;

			}
		}
		return answer;
	}
//				if (ladder[i][j] > n || ladder[i][j] < 1) { // 인덱스 범위 체크
//					throw new IllegalArgumentException("Invalid ladder input");
//				}
	// System.out.println(ladder[i][j]);
	// System.out.println(ladder[i][j] - 1);

	
	
	
	public static void main(String[] args) {
		P1 T = new P1();
		System.out.println(Arrays.toString(T.solution(5, new int[][] { { 1, 3 }, { 2, 4 }, { 1, 4 } })));
		System.out.println(Arrays.toString(T.solution(7, new int[][] { { 1, 3, 5 }, { 1, 3, 6 }, { 2, 4 } })));
		System.out.println(
				Arrays.toString(T.solution(8, new int[][] { { 1, 5 }, { 2, 4, 7 }, { 1, 5, 7 }, { 2, 5, 7 } })));
		System.out.println(Arrays.toString(T.solution(12,
				new int[][] { { 1, 5, 8, 10 }, { 2, 4, 7 }, { 1, 5, 7, 9, 11 }, { 2, 5, 7, 10 }, { 3, 6, 8, 11 } })));

	}

}