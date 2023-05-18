package Java_230404;

public class Java_0404_16 {

	public static void main(String[] args) {
		int K23_n, K23_m; // n, m 변수 int형 정의

		K23_m = 20; // m에 20 대입
		K23_n = 1; // n에 1 대입

		while (true) { // while 반복문
			for (int K23_i = 0; K23_i < K23_m; K23_i++) { // i는 0부터 m-1까지 반복
				System.out.printf(" "); // 빈칸 출력
			}
			for (int K23_i = 0; K23_i < K23_n; K23_i++) { // i는 0부터 n-1까지 반복
				System.out.printf("*"); // 별 찍기
			}
			System.out.printf("\n"); // 줄 바꿈
			K23_m = K23_m - 1; // 왼쪽의 빈칸의 개수가 1개씩 줄어들기 때문에
			K23_n = K23_n + 2; // 별의 개수가 2개씩 늘어나기 때문에

			if (K23_m < 0) { // m < 0 일 때
				break; // while문 탈출
			}
		}
	}
}
