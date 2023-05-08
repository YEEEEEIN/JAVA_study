package P12;

import java.util.Scanner;

public class P12_Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		float result1, result2;

		System.out.println("1. Celsius -> Fahrenheit");
		System.out.println("2. Fahrenheit -> Celsius");
		int input = scanner.nextInt(); // celsius 섭씨
		int temperture = scanner.nextInt(); // fahrenheit 화씨

		// 화씨 섭씨 변환은 화씨 온도에서 32를 빼고 5/9를 곱하는 공식
		// 이 공식은 0.5556을 곱하는 것과 같다

		if (input == 1) { // 섭씨 -> 화씨
			result1 = temperture * 9 / 5 + 32;
			System.out.println(result1);
		} else if (input == 2) { // 화씨 -> 섭씨
			result2 = (temperture - 32) * 5 / 9;
			System.out.println(result2);
		} else {
			System.out.println("retry!");
		}

	}

}
