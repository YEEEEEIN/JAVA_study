package day1;

import java.util.Arrays;

class P2 {
	public int[] solution(int[][] board, int k) {
		int[] answer = new int[2];

		int n = board.length;

		// 방향키 index 설정
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // 북동남서
		int x = 0;
		int y = 0;
		int d = 1; // 기본적으로 동쪽을 바라보게 설정
		int count = 0;
		while (count < k) {
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
				d = (d+1) % 4; // d 값이 커지지 않게 다시 세팅
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;

		return answer;

	}

	public static void main(String[] args) {
		P2 T = new P2();
		int[][] arr1 = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = { { 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}
}
