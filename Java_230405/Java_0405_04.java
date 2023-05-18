package Java_230405;

public class Java_0405_04 {

	public static void main(String[] args) { // 가로로 세줄씩 구구단
		// 고정된 값을 바깥쪽 for문에
		// 변하는 값을 안쪽 for문에 
		for (int k23_i = 1; k23_i <= 9; k23_i += 3) { // k23_i는 1부터 3씩 증가하면서 9까지 반복 => k23_i단
			System.out.printf("************** ************** **************\n"); // 출력
			System.out.printf("구구단 %d단\t구구단 %d단\t구구단 %d단\n", k23_i, k23_i + 1, k23_i + 2); // 한 줄에 연속된 단을 출력하기 위해서
			System.out.printf("************** ************** **************\n"); // 출력
			for (int k23_j = 1; k23_j <= 9; k23_j++) { // n단의 1~9 곱
				System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
						k23_i, k23_j, k23_i * k23_j, // k23_i * k23_j 구구단 계산 출력 
						k23_i + 1, k23_j, (k23_i + 1) * k23_j, // k23_i * k23_j 구구단의 +1단 출력 
						k23_i + 2, k23_j, (k23_i + 2) * k23_j); // k23_i * k23_j 구구단의 +2단 출력 
			}
		}
	}
}
