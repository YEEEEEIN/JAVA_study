package Java_230405;

public class Java_0405_05 {

	public static void main(String[] args) { // 세로로 세줄씩 구구단 
		// 고정된 값을 바깥쪽 for문에
		// 변하는 값을 안쪽 for문에 
		for (int k23_i = 1; k23_i <= 3; k23_i++) { // k23_i는 1부터 1씩 증가하면서 3까지 반복 => k23_i단
			System.out.printf("************** ************** **************\n");
			System.out.printf("구구단 %d단\t구구단 %d단\t구구단 %d단\n", k23_i, k23_i + 3, k23_i + 6); // 한 줄에 연속된 단을 출력하기 위해서
			System.out.printf("************** ************** ************** \n");
			for (int k23_j = 1; k23_j <= 9; k23_j++) {
				System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
						k23_i, k23_j, k23_i * k23_j, // k23_i * k23_j 구구단 출력 
						k23_i + 3, k23_j, (k23_i + 3) * k23_j, // k23_i * k23_j 구구단의 +3단 출력 
						k23_i + 6, k23_j, (k23_i + 6) * k23_j); // k23_i * k23_j 구구단의 +6단 출력 
			}
		}
	}
}
