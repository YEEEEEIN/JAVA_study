package Java_230404;

public class Java_0404_03 {

	public static void main(String[] args) {
		int k23_sum = 0; // 변수 k23_sum int형 정의하고 0으로 초기화
		for (int k23_i = 0; k23_i < 10; k23_i++) { // k23_i는 0부터 10 전까지 i를 1씩 증가
			k23_sum = k23_sum + k23_i; // k23_sum + k23_i을 k23_sum에 대입 (누적)
		}
		System.out.printf("k23_sum %d\n", k23_sum); // k23_sum 출력
		
		// for문 구구단
		for (int k23_i = 1; k23_i < 10; k23_i++) { // k23_i는 1부터 10 전까지 k23_i를 1씩 증가
			System.out.printf("******************\n"); // 출력
			System.out.printf("구구단 %d 단\n", k23_i); // k23_i 출력
			System.out.printf("******************\n"); // 출력
			for (int k23_j = 1; k23_j < 10; k23_j++) { // k23_j는 1부터 10 전까지 k23_i를 1씩 증가
				System.out.printf(" %d x %d = %d \n", k23_i, k23_j, k23_i * k23_j); // k23_i, k23_j, k23_i * k23_j 출력
			}
		}
	}
}
