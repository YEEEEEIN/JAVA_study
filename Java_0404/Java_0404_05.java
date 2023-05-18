package Java_0404;

public class Java_0404_05 {

	public static void main(String[] args) {
		// 별찍기
		int k23_iA, k23_iB; // 변수 k23_iA, k23_iB int형 선언

		k23_iA = 0; // k23_iA에 0 대입
		while (true) {
			k23_iB = 0; // k23_iB에 0 대입
			while (true) {
				System.out.print("*"); // k23_iA == k23_iB이 같기 전까지 별찍기
				if (k23_iA == k23_iB) // k23_iA == k23_iB이면
					break; // 안 쪽 while문 탈출
				k23_iB++; // k23_iB + 1
			}
			System.out.print("\n"); // 줄바꿈
			k23_iA++; // k23_iA + 1
			if (k23_iA == 30) // k23_iA == 30이면
				break; // 바깥 쪽 while문 탈출 => 별찍기 종료
		}
	}
}
