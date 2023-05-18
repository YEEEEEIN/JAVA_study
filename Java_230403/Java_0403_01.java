package Java_230403;

public class Java_0403_01 {

	public static void main(String[] args) {
		
		// #1. 연산 후 대입, 당연히 사칙연산의 순서
		int k23_ii; // 변수 k23_ii 정수로 선언
		k23_ii = 1 + 2; // 1 + 2를 계산한 값(3)을 k23_ii에 대입
		System.out.printf("#1-1 : %d\n", k23_ii); // 정수는 printf문에서 %d로 받음

		k23_ii = 1 + 2 * 3; // 사칙연산은 덧셈보다 곱셉이 우선
		System.out.printf("#1-2 : %d\n", k23_ii); // k23_ii 값 출력

		
		// #2. 누적하기, 합구하기
		int k23_sum; // 변수 k23_sum 정수로 선언

		k23_sum = 0; // 변수 초기화... 누적, 루프는 꼭 초기화해야 함!!!

		for (int k23_i = 1; k23_i < 101; k23_i++) { // 반복문 정수 i=1~100까지 반복
			k23_sum = k23_sum + k23_i; //
		}
		System.out.printf("#2 : %d\n", k23_sum); // k23_sum의 값 출력
		System.out.printf("#2 : %d\n", k23_sum / 100); // k23_sum / 100 을 출력

		int[] k23_v = { 1, 2, 3, 4, 5 }; // 배열 선언과 변수에 값을 넣어 초기화를 동시에 함
		int k23_vSum; // 정수 선언

		k23_vSum = 0; // 변수 초기화

		for (int k23_i = 1; k23_i < 5; k23_i++) { // for반복문. 정수 i(1~4)까지 반복
			k23_vSum = k23_vSum + k23_v[k23_i]; // 1~4번째 배열의 값(2, 3, 4, 5) 누적하여 더하기
		}
		System.out.printf("#2-3 : %d\n", k23_vSum); // k23_vSum의 값 출력

		
		// #3. 정수형 변수의 나눗셈은 정수범위에서 버림처리
		k23_ii = 1000 / 3; // 정수끼리의 나눗셈 -> 3.33333333... 이 나오지 않는다
		System.out.printf("#3-1 : %d\n", k23_ii); // 정수값(3)만 출력

		k23_ii = 1000 % 3; // 나머지 계산할 때는 % 사용
		System.out.printf("#3-2 : %d\n", k23_ii); // 나머지(1) 출력

		// 나머지 연산자의 응용
		for (int k23_i = 1; k23_i < 20; k23_i++) { // for반복문. 정수 i(1~19)까지 반복
			System.out.printf("#3-3 : %d ", k23_i); // 정수 i의 값(1~19) 19개 출력

			if (((k23_i + 5) % 5) == 0) { // 5로 나눈 값이 0일 때 마다 == 5자리 마다
				System.out.printf("\n"); // 줄 바꿈
			}
		}
		System.out.printf("\n");

		
		// #4. 원하는 자릿수 반올림, 버림처리
		k23_ii = 12345; // 12345원 10원 이하 버려서 처리하기
		int k23_j = (k23_ii / 10) * 10; // 정수형끼리의 연산은 정수형을 반환 (k23_ii / 10) = 1234
		System.out.printf("#4-1 : %d\n", k23_j); // -> (k23_ii / 10) * 10 12340

		k23_ii = 12345; // 12345원 10원 이하 반올림하여 처리하기
		k23_j = ((k23_ii + 5) / 10) * 10; // 반올림의 기준인 5를 더해서 10초과 시 올림
		System.out.printf("#4-2 : %d\n", k23_j); // 올림한 값(12350) 출력
		
		k23_ii = 12344; // 12345원 10원 이하 반올림하여 처리하기
		k23_j = ((k23_ii + 5) / 10) * 10; // 반올림의 기준인 5를 더해서 10미만 시 버림
		System.out.printf("#4-3 : %d\n", k23_j); // 내림한 값(12340) 출력

		
		// #5. 소수점 이하에서는 어떻게 할까?
		int k23_MyVal = 14 / 5; // int형끼리의 연산
		System.out.printf("#5-1 : %d\n", k23_MyVal); // int형으로 반환

		double k23_MyValF; // double형 선언

		k23_MyValF = 14 / 5; // int형 결과 값(2)을 double형 처리
		System.out.printf("#5-2 : %f\n", k23_MyValF); // 2.000000

		k23_MyValF = 14.0 / 5; // double형, int형 연산 => double형
		System.out.printf("#5-3 : %f\n", k23_MyValF); // 2.800000

		k23_MyValF = (14.0) / 5 + 0.5; // 사칙연산 곱셈, 나눗셈 먼저
		System.out.printf("#5-4 : %f\n", k23_MyValF); // 3.300000

		k23_MyValF = (int) ((14.0) / 5 + 0.5); // int형으로 강제 형변환한 값(3) -> k23_MyValF가 double형이기 때문에
		System.out.printf("#5-5 : %f\n", k23_MyValF); // 3.000000

	}
}