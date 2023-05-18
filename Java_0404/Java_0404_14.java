package Java_0404;

public class Java_0404_14 {

	public static void main(String[] args) {
		// 띄어쓰기 연습
		
		for (int k23_i = 0; k23_i < 10; k23_i++) { // k23_i는 0~9까지 반복
			// 공백을 점점 늘려가야하기 때문에
			// 안쪽 for문(공백 출력)의 범위를 바깥쪽 for문(숫자 출력)의 k23_i 값으로 지정
			// ==> k23_i가 증가함에 따라 공백도 같이 증가함
			for (int k23_j = 0; k23_j < k23_i; k23_j++) { 
				System.out.printf(" "); // 공백 출력
				
				
			} 
			System.out.printf("%d\n", k23_i); // k23_i 출력
		}
	}
}
