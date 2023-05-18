package Java_0404;

public class Java_0404_11 {

	public static void main(String[] args) {
		// 비정형 비교(룰이 애매한)는 배열을 이용하는 것도 한 방법이다.
		
		int [] k23_iLMD = {31,28,31,30,31,30,31,31,30,31,30,31}; // 변수 k23_iLMD int형 배열 정의, 초기화
		// 단 배열은 0부터 시작한다는 것에 유의
		// iLMD[0] ~iLMD[11]
		
		for (int k23_i = 1; k23_i < 13; k23_i++) { // k23_i(월)는 1~12까지 반복
			System.out.printf(" %d월 =>", k23_i); // k23_i 출력
			for (int k23_j = 1; k23_j < 32; k23_j++) { // k23_j(일)는 1~31까지 반복
				System.out.printf("%d", k23_j); // k23_j 출력
				if(k23_iLMD[k23_i - 1] == k23_j) { // 배열의 값과 k23_j가 같으면
					break; // 안쪽 for문 탈출
				}
				System.out.printf(","); // 마지막일에 콤마 안찍기
			}
			System.out.printf("."); // 마지막일에 점 찍기
			System.out.printf("\n"); // 개행
		}
	}
}
