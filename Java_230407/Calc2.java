package Java_230407;

public class Calc2 {
	public int sum(int a, int b, int c) { // int형 인자 3개를 받는 sum 함수
		return a + b + c; // 3개의 인자의 합(int형) 리턴
	}

	public int sum(int a, int b, int c, int d) { // int형 인자 4개를 받는 sum 함수
		return a + b + c + d; // 4개의 인자의 합(int형) 리턴
	}

	public int sum(int a, int b, int c, int d, int e) { // int형 인자 5개를 받는 sum 함수
		return a + b + c + d + e; // 5개의 인자의 합(int형) 리턴
	}

	// 평균
	public double avg(int sum, int num) { // int형 인자 5개를 받아 sum 함수
		return (double) sum / num; // double형 리턴
	}

}
