package P8;

import java.util.Arrays;
import java.util.Scanner;

/*
Exception Handling
-User inputs a number and the number defines the size of an array
-User inputs numbers more than the defined size
-In this case, this program prints “error” and starts again from the beginning,
 Otherwise, assign the numbers into the array, sort and print them

5
1 3 4 5 7 8
error
4
1 22 6 12
1 6 12 22

 */

public class P8_Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		// size of an array
//		while (true) {
//			System.out.println("input size of an array");
//			int size = sc.nextInt();
//			int[] arr = new int[size];
//			
//			while (true) {
//				int input = sc.nextInt();
//				
//				if()
//				
//				arr = input.split(" ");
//				Arrays.sort(arr);
//				for (int i = 0; i < arr.length; i++) {
//					System.out.println(arr[i]);
//				}
//			}
//			
//		}
		Scanner scanner = new Scanner(System.in);
		int[] numbers;

		// Array size 다시 입력 받는 루프
		while (true) {
			System.out.println("Array Size를 입력하세요.");

			int inputNum = scanner.nextInt();
			numbers = new int[inputNum];
			boolean check = false;

			// 입력된 숫자가 몇개인지 count하는 변수
			int count = 0;
			// Array size만큼 숫자 재입력 받는 루프
			while (true) {
				// numbers 배열에 들어갈 숫자 입력
				int num = scanner.nextInt();
		
				try {
					// num이 -1이면 break
					if (num == -1) {
						// count가 intputNum까지 입력되었으면 break
						if (count == inputNum) {
							check = true;
							break;
						// count가 inputNum보다 적게 입력되었으면 추가입력
						} else {
							System.out.println("추가입력");
						}
					// numbers에 숫자 넣어주고, 몇개가 입력되었는지 count
					} else {
						numbers[count] = num;
						count++;
					}
				// 배열크기를 초과하면 에러 및 break
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Error");
					break;
				}
			}
			// count = inputNum 같으면 루프 종료
			if (check == true) {
				break;
			}
		}
		// 배열 sort
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		
	}

}
