package day1;

import java.util.Arrays;

class P2 {
	public int[] solution(int[][] board, int k) {
		int[] answer = new int[2];

		int n = board.length;

		// ����Ű index ����
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // �ϵ�����
		int x = 0;
		int y = 0;
		int d = 1; // �⺻������ ������ �ٶ󺸰� ����
		int count = 0;
		while (count < k) {
			count++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
				d = (d+1) % 4; // d ���� Ŀ���� �ʰ� �ٽ� ����
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
