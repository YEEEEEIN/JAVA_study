package Java_230404;

public class Java_0404_04 {

	public static void main(String[] args) {
		// while문 구구단
		int k23_i = 2; // 변수 k23_i int형 정의하고 2 초기화
		while (k23_i <= 9) { // k23_i<=9 while문 반복
			int k23_j = 1; // 변수 k23_j int형 정의하고 1 초기화
			while (k23_j <= 9) { // k23_j<=9 while문 반복
				System.out.println(k23_i + " x " + k23_j + " = " + k23_i * k23_j); // 출력
				k23_j++; // k23_j + 1
			}
			System.out.println(""); // 줄바꿈
			k23_i++; // k23_i + 1
		}
	}
}
