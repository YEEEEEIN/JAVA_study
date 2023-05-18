package Java_230404;

public class Java_0404_12 {

	public static void main(String[] args) {
		String[] k23_units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" }; // 변수 k23_units String 배열 선언, 초기값 설정
		for (int k23_i = 0; k23_i < 101; k23_i++) { // k23_i는 0~100까지 반복

			if (k23_i >= 0 && k23_i < 10) { // k23_i 0~9까지
				System.out.printf("일의자리 : %s\n", k23_units[k23_i]); // k23_units[k23_i] 출력
			}

			else if (k23_i >= 10 && k23_i < 100) { // k23_i 10~99까지
				int k23_i10, k23_i0; // k23_i10, k23_i0 정수 선언
				k23_i10 = k23_i / 10; // 일의자리 절삭 -> 10의자리 수
				k23_i0 = k23_i % 10; // 나머지 -> 1의자리 수
				
				if (k23_i0 == 0) { // 1의자리가 0이면
					System.out.printf("십의자리 : %s십\n", k23_units[k23_i10]); // 10의 자리 수만 출력
				} else { // 1의자리가 0이 아니면
					System.out.printf("십의자리 : %s십%s\n", k23_units[k23_i10], k23_units[k23_i0]); // 10의 자리 수와 1의 자리 수 출력
				}
				
			} else { // 그 외에는
				System.out.printf("==> %d\n", k23_i); // 변수 k23_i 출력
			}
		}
	}
}
