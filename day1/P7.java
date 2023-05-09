package day1;

import java.util.Arrays;

class P7 {
	public int solution(int[] keypad, String password) {
		int answer = 0;
		int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 방향키 - 내 주변을 둘러싸고 있는 부분
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[][] pad = new int[3][3]; // 2차원 배열로 변환
		int[][] dist = new int[10][10]; // 만능 키패드 x-> y로의 시간
		// 2차원 배열 값 넣기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pad[i][j] = keypad[i * 3 + j]; // 현업에서 쓰는 방식
			}
		}
		// 만능 키패드 값 넣기
		for (int i = 0; i < 10; i++) {
			Arrays.fill(dist[i], 2); // 2차원 배열을 모두 2로 채우는 명령문
		}
		for (int i = 0; i < 10; i++) {
			dist[i][i] = 0; // 자기 자신으로 이동 => 0
			}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int from = pad[i][j];
				for (int k = 0; k < 8; k++) { // 방향키
					if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
						int to = pad[i + dx[k]][j + dy[k]];
						dist[from][to] = 1; // 만능 키패드
					}
				}

			}
		}

		for (int i = 1; i < password.length(); i++) { // 비밀번호 처음 숫자는 이동하지 않기 때문에 1부터 시작한다
			int from = (int)password.charAt(i-1)-48; // 7에서
			int to = (int)password.charAt(i)-48; // 5로 이동
			answer += dist[from][to]; // 그때의 만능키패드에 적힌 dist값(이동하는데 걸리는 시간)

		}

		return answer;
	}

	public static void main(String[] args) {
		P7 T = new P7();
		System.out.println(T.solution(new int[] { 2, 5, 3, 7, 1, 6, 4, 9, 8 }, "7596218"));
		 System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6},
		 "63855526592"));
		 System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1},
		 "323254677"));
		 System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2},
		 "3337772122"));
	}
}
