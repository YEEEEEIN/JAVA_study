package Java_230404;

public class Java_0404_02 {

	public static void main(String[] args) {
		/*
		// printf문
		 System.out.println(1); // 1 출력
		 System.out.println(2); // 2 출력
		 System.out.println(3); // 3 출력
		 System.out.println(4); // 4 출력
		 System.out.println(5); // 5 출력
		 */
		
		/*
		// for문
		for (int k23_i = 1; k23_i <= 5; k23_i++) { // k23_i는 1부터 5까지 하나씩 증가하면서 
			System.out.println(k23_i); // 출력
		}
		*/
		

		/*
		// while문
		int k23_i = 1; // 변수 k23_i를 int로 정의하고 1로 초기화
		while (k23_i<=5) { // k23_i를 5까지
			System.out.println(k23_i); // k23_i 출력
			k23_i++; // k23_i + 1 
		}
		*/
		
		
		
		
		// do-while문
		int k23_i = 0; // 변수 k23_i를 int로 정의하고 0로 초기화
		do { // 우선 실행 
			k23_i++; // k23_i + 1 
			System.out.println(k23_i); // k23_i 출력
		} while (k23_i < 5); // k23_i를 5까지, 초과 시 while문 탈출
		
	}
}
