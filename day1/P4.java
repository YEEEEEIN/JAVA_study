package day1;

import java.util.Arrays;

class P4 {
	public int[] solution(int c, int r, int k) {
		int[] answer = new int[2];
		if (k > c * r)
			return new int[] { 0, 0 };
		int[][] board = new int[c][r]; // 2���� �迭 ����

		// ����Ű index ����
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // �ϵ�����
		int x = 0;
		int y = 0;
		int d = 1; // �⺻������ ������ �ٶ󺸰� ����
		int count = 1;
		while (count < k) {

			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= c || ny < 0 || ny >= r || board[nx][ny] == 1) {
				d = (d + 1) % 4; // d ���� Ŀ���� �ʰ� �ٽ� ����
				continue;
			}
			board[x][y] = 1; // �� x,y ������ �������� ������ ����
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
