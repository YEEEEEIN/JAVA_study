package Java_0404;

public class Java_0404_10 {

	public static void main(String[] args) {
		// 억지
		// 거의 이런 표현은 안함
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i는 1~12까지 반복
			System.out.printf(" %d월 =>", k23_i); // k23_i 출력
			LOOP: for (int k23_j = 1; k23_j < 32; k23_j++) { // k23_j는 1~31까지 반복
				System.out.printf("%d,", k23_j); // k23_j 출력
				switch (k23_i) { // k23_i가
				case 4: // 4일 때
				case 6: // 6일 때
				case 9: // 9일 때
				case 11: // 11일 때
					if (k23_j == 30) { // k23_j이 30이면
						break LOOP; // LOOP 탈출
					}
					break; // switch case 탈출 -> 없으면 28일 까지 출력
				case 2: // 2일 때
					if (k23_j == 28) { // k23_j이 28이면
						break LOOP; // LOOP 탈출
					}
					break; // switch case 탈출
				}
			}
			System.out.printf("\n"); // 개행
		}
	}
}