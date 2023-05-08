package A1;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
Numbering
- User inputs a series of numbers and assign them to a queue
- User input a number from the series of numbers
- Print the number in order of output
- Add exception statements

1 21 13 34 15 16
13
3
 */

public class A1_Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("숫자를 입력하세요");
				String[] input = sc.nextLine().split(" "); // 문자열을 공백을 기준으로 쪼개 배열에 넣기
				for (int i = 0; i < input.length; i++) {
					stack.push(Integer.parseInt(input[i])); // nextLine()이 띄어쓰기가 포함되어 있기 때문에
				}
			} catch (NumberFormatException e) {
				System.out.println("올바른 형식으로 입력하세요.");
				sc.nextLine(); // 입력 버퍼를 비웁니다.
			}
			// 위랑 같은 의미 (for-each 루프)
			// for (String str : input) {
			// queue.add(Integer.parseInt(str));
			// }

			System.out.println("Stack에서 찾을 숫자를 입력하세요");
			try {
				int target = sc.nextInt();
				// 찾을 숫자 위치 찾기
				int index = 1;
				while (!stack.isEmpty()) {
					int num = stack.pop();
					index++;

					if (num == target) {
						System.out.println(index);
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("올바른 형식으로 입력하세요.");
				sc.nextLine(); // 입력 버퍼를 비웁니다.
			}
			break;
		}
	}
}
