package Java_0404;

public class Java_0404_08 {

	public static void main(String[] args) {
		// 프로그래밍은 몇 줄 아끼는 것 보다 직관적인게 좋다
		// 마지막은 .로 끝내기 추가
		
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i는 1~12까지 반복 => 월
			System.out.printf(" %d월 =>", k23_i); // k23_i 출력
			for (int k23_j= 1; k23_j < 32; k23_j++) { // k23_j는 1~31까지 반복 => 일
				System.out.printf("%d,", k23_j - 1); // k23_j - 1까지는 ,찍어서 출력

				if (k23_i == 1 && k23_j == 31) { // 1월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 2 && k23_j == 28) { // 2월 28일
					System.out.printf("%d.", k23_j); // k23_j = 28 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 3 && k23_j == 31) { // 3월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 4 && k23_j == 30) { // 4월 30일
					System.out.printf("%d.", k23_j); // j = 30 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 5 && k23_j == 31) { // 5월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				 
				if (k23_i == 6 && k23_j == 30) { // 6월 30일
					System.out.printf("%d.", k23_j); // k23_j = 30 .찍어서 출력
					break; // for문 탈출
				}
				 
				if (k23_i == 7 && k23_j == 31) { // 7월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 8 && k23_j == 31) { // 8월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 9 && k23_j == 30) { // 9월 30일
					System.out.printf("%d.", k23_j); // k23_j = 30 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 10 && k23_j == 31) { // 10월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 11 && k23_j == 30) { // 11월 30일
					System.out.printf("%d.", k23_j); // k23_j = 30 .찍어서 출력
					break; // for문 탈출
				}
				
				if (k23_i == 12 && k23_j == 31) { // 12월 31일
					System.out.printf("%d.", k23_j); // k23_j = 31 .찍어서 출력
					break; // for문 탈출
				}
			}
			System.out.printf("\n");

		}
	}
}
