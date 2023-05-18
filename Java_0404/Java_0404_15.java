package Java_0404;

public class Java_0404_15 {
	public static void main(String[] args) {
		// sin 그래프를 그려보자
		// 360도 : 2pi = 1도 : x
		// x = pi / 180 => 1 / 1라디안

		double k23_fSin; // 변수 k23_fSin double형 정의

		for (int k23_i = 0; k23_i < 360; k23_i++) { // sin은 0~360반복이기 때문에
			k23_fSin = Math.sin(k23_i * 3.141592 / 180); // Math.sin 함수와 라디안 값이용하여 sin 값 대입
			System.out.printf("sin %d ==> %f\n", k23_i, k23_fSin); // 각도, sin 값 출력
		}

		// 360도 까지 그리자
		for (int k23_i = 0; k23_i < 360; k23_i++) { // sin은 0~360반복이기 때문에
			k23_fSin = Math.sin(k23_i * 3.141592 / 180); // Math.sin 함수와 라디안 값이용하여 sin 값 대입

			// -k23_fSin값은 -1 ~ 1 이기 때문에 공간을 양수를 만들기 위해서
			// +1에서 하여 0 ~ 2 범위를 만든다
			int k23_iSpace = (int) ((1.0 - k23_fSin) * 50); // 공백을 만들기 위해 넉넉하게 50을 곱해줌
			for (int k23_j = 0; k23_j < k23_iSpace; k23_j++) { // k23_j부터 k23_j의 k23_iSpace(공백) 만큼
				System.out.printf(" "); // 공백 출력
			}
			System.out.printf("*[%f][%d]\n", k23_fSin, k23_iSpace); // 사인 값, 공백 값 출력
		}

	}

}
