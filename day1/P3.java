package day1;

class P3 {
	public int solution(int[][] board) {

		// ����Ű index ����
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // �ϵ�����
		int x1 = 0; // ����
		int y1 = 0;
		int x2 = 0; // ������
		int y2 = 0;
		int d1 = 0; // �⺻������ ������ �ٶ󺸰� ����
		int d2 = 0;
		int count = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 2) { // ���� ��ġ ã��
					x1 = i;
					y1 = j;

				}
				if (board[i][j] == 3) { // ������ ��ġ ã��
					x2 = i;
					y2 = j;
				}
			}
		}

		while (count < 10000) {
			count++;
			
			int nx1 = x1 + dx[d1]; // ����ġ
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];
			boolean flag1 = true, flag2 = true;
			if (nx1 < 0 || nx1 >= 10 || ny1 < 0 || ny1 >= 10 || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4; // d ���� Ŀ���� �ʰ� �ٽ� ����
				flag1 = false;
			}
			if (nx2 < 0 || nx2 >= 10 || ny2 < 0 || ny2 >= 10 || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4; // d ���� Ŀ���� �ʰ� �ٽ� ����
				flag2 = false;
			}
			if (flag1 == true) {
				x1 = nx1;
				y1 = ny1;
			}
			if (flag2 == true) {
				x2 = nx2;
				y2 = ny2;
			}
			// ���� ��ġ�� ������
			if ((x1 == x2) && (y1 == y2)) {
				break;
			}

		}

		if (count >= 10000)
			return 0;
		return count;

	}

	public static void main(String[] args) {
		P3 T = new P3();
		int[][] arr1 = { { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 2, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 3, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 } };
		System.out.println(T.solution(arr1));
		int[][] arr2 = { { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 2, 1 },
				{ 0, 0, 0, 1, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0, 0, 0, 0, 0, 3 } };
		System.out.println(T.solution(arr2));
	}
}