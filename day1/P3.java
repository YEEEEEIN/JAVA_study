package day1;

class P3 {
	public int solution(int[][] board) {

		// 방향키 index 설정
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 }; // 북동남서
		int x1 = 0; // 현수
		int y1 = 0;
		int x2 = 0; // 강아지
		int y2 = 0;
		int d1 = 0; // 기본적으로 동쪽을 바라보게 설정
		int d2 = 0;
		int count = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (board[i][j] == 2) { // 현수 위치 찾기
					x1 = i;
					y1 = j;

				}
				if (board[i][j] == 3) { // 강아지 위치 찾기
					x2 = i;
					y2 = j;
				}
			}
		}

		while (count < 10000) {
			count++;
			
			int nx1 = x1 + dx[d1]; // 예측치
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];
			boolean flag1 = true, flag2 = true;
			if (nx1 < 0 || nx1 >= 10 || ny1 < 0 || ny1 >= 10 || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4; // d 값이 커지지 않게 다시 세팅
				flag1 = false;
			}
			if (nx2 < 0 || nx2 >= 10 || ny2 < 0 || ny2 >= 10 || board[nx2][ny2] == 1) {
				d2 = (d2 + 1) % 4; // d 값이 커지지 않게 다시 세팅
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
			// 둘의 위치가 같으면
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
