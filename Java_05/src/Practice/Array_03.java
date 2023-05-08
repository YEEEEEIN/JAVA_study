package Practice;

public class Array_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numbers = { { 1, 2, 3 }, { 4, 5 } };

		for (int i = 0; i < numbers.length; i++) { // 범위 오류 수정
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j]);
			}
		}

//		for (int i = 0; i < 2; i++) { //Error 범위 오류
//			for (int j = 0; j <3; j++) {
//				System.out.println(numbers[i][j]);
//			}
//		}
	}

}
