package Practice;

public class Array_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numbers = new int[3][5];
		int cnt;
		cnt = 0;
		for (int i = 0; i < numbers.length; i++) { //범위 배열에 맞게 수정
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = cnt;
				cnt++;

			}
		}
		
		// 배열 출력
		// System.out.println(numbers)은 배열의 메모리 주소를 출력하며, 실제로 배열의 내용을 출력하지 않습니다.
		for (int i = 0; i < numbers.length; i++) {
		    for (int j = 0; j < numbers[i].length; j++) {
		        System.out.print(numbers[i][j] + " ");
		    }
		    System.out.println(); // 다음 줄로 넘어가기 위해 개행문자를 출력
		}

	}

}
