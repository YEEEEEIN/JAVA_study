package Java_230404;

public class Java_0404_06 {

	public static void main(String[] args) {
		int k23_iI; // 변수 k23_iI int형 정의
		double k23_iD; // 변수 k23_iD double 형 정의

		k23_iI = 10 / 3; // 10/3의 값 k23_iI에 대입
		k23_iD = 10 / 3.0; // 10 / 3.0의 값 k23_iD에 대입

		// int와 double은 정수형 연산과 실수형 연산이다
		if (k23_iI == k23_iD) { // k23_iI == k23_iD이라면
			System.out.printf("equal\n"); // 출력
		} else { // k23_iI != k23_iD
			System.out.printf("Not equal[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI , k23_iD 출력
		}

		// 단지 유효숫자까지 표시된 것 뿐이지 다르다
		if (k23_iD == 3.333333) { // k23_iD == 3.333333이면
			System.out.printf("equal\n"); // 출력
		} else { // k23_iD != 3.333333
			System.out.printf("Not equal[3.333333][%f]\n", k23_iD); // k23_iD 출력
		}

		k23_iD = (int) k23_iD; // 변수 k23_iD int형으로 형변환, k23_iD = 3
		if (k23_iI == k23_iD) { // k23_iI == k23_iD라면
			System.out.printf("equal\n"); // 출력
		} else { // k23_iI != k23_iD
			System.out.printf("Not equal[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI, k23_iD 출력
		}

		System.out.printf("int로 인쇄[%d][%f]\n", k23_iI, k23_iD); // k23_iI, k23_iD 출력
		System.out.printf("double로 인쇄[%f][%f]\n", (double) k23_iI, k23_iD); // (double) k23_iI, k23_iD) 출력

		char k23_a = 'c'; // 변수 k23_a char형 정의, 'c'로 초기화

		if (k23_a == 'b') { // k23_a == 'b'라면
			System.out.printf("a는 b이다\n"); // 출력
		}
		if (k23_a == 'c') { // k23_a == 'c'라면 // 출력
			System.out.printf("a는 c이다\n");
		}
		if (k23_a == 'd') { // k23_a == 'd'라면 // 출력
			System.out.printf("a는 d이다\n");
		}

		String k23_aa = "abcd"; // String은 변수가 아닌 클래스
		if (k23_aa.equals("abcd")) { // String은 클래스 이기 때문에 equals 함수 사용
			System.out.printf("aa는 abcd이다\n"); // 출력
		} else { // k23_aa 가 "abcd"가 아니라면
			System.out.printf("aa는 abcd이 아니다\n"); // 출력
		}

		boolean k23_bb = true; // 변수 k23_bb boolean형 정의, true로 초기화
		if (!!k23_bb) { // k23_bb가 아닌게 아니면
			System.out.printf("bb가 아니고 아니면 참이다\n"); // 출력
		} else { // k23_bb가 아닌게 아닌게 아니면
			System.out.printf("bb가 아니고 아니면 거짓이다\n"); // 출력
		}
	}

}
