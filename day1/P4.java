package day1;

import java.util.Arrays;

class P4 {
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];
		if (k > c * r)
			return new int[] { 0, 0 };
		int[][] board = new int[c][r]; // 2차원 배열 선언

		// 방향키 index 설정
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // 북동남서
		int x = 0;
		int y = 0;
		int d = 1; // 기본적으로 동쪽을 바라보게 설정
		int count = 1;
		while (count < k) {

			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] == 1) {
				d = (d + 1) % 4; // d 값이 커지지 않게 다시 세팅
				continue;
			}
			board[x][y] = 1; // 가 x,y 밑으로 내려가면 더해진 갑시
			count++;
			x = nx;
			y = ny;
		}

		answer[0] = x + 1;
		answer[1] = y + 1;

		return answer;

	}

	public static void main(String[] args) {
		P4 T = new P4();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
