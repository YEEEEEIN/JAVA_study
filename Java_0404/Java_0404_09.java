package Java_0404;

public class Java_0404_09 {

	public static void main(String[] args) {
		for (int k23_i = 1; k23_i <13; k23_i++) { // k23_i는 1~12까지 반복
			System.out.printf(" %d월 =>", k23_i); // k23_i 출력
			for (int k23_j= 1; k23_j < 32; k23_j++) { // k23_j는 1~31까지 반복
				System.out.printf("%d,", k23_j); // k23_j 출력
				
				if(k23_i == 4 || k23_i == 6 || k23_i == 9 || k23_i == 7 || k23_i == 11) { // k23_i == 4, 6, 9, 7, 11 중 하나 이면서
					if (k23_j == 30) { // k23_j가 30일 때
						break; // for문 탈출
					}
				}
				
				if(k23_i == 2) { // k23_i == 2 중 하나 이면서
					if (k23_j == 28) { // k23_j가 28일 때
						break; // for문 탈출
					}
				}
			}
			System.out.printf("\n"); // 개행
		}
	}
}
