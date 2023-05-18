package Java_0404;

public class Java_0404_07 {

	public static void main(String[] args) {
		// 범위 주어서 찾기
		int k23_iVal; // 변수 int 정의
		for (int i = 0; i < 300; i++) { // i는 0~299끼지
			k23_iVal = 5 * i; // 5 * i값을 k23_iVal에 대입
			if (k23_iVal >= 0 && k23_iVal < 10) { // 0 <= k23_iVal <10 이면
				System.out.printf("일 %d\n", k23_iVal); // 변수 출력
			} else if (k23_iVal >= 10 && k23_iVal < 100) { // 10 <= k23_iVal <100 이면
				System.out.printf("십 %d\n", k23_iVal); // 변수 출력
			} else if (k23_iVal >= 100 && k23_iVal < 1000) { // 100 <= k23_iVal <1000 이면
				System.out.printf("백 %d\n", k23_iVal); // 변수 출력
			} else { // k23_iVal >= 1000 이면
				System.out.printf("천 %d\n", k23_iVal); // 변수 출력
			}
		}
	}
}
