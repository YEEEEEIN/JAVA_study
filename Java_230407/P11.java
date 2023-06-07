package Java_230407;

public class P11 {

	public static void main(String[] args) {
		Calc2 cc2 = new Calc2(); // Calc2 클래스의 cc2 객체 생성
		
		System.out.printf("3월 성적표\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		System.out.printf("이름\t국어\t영어\t수학\t총정\t평균\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		int sum3 = cc2.sum(100, 100, 100); // cc2 인스턴스의 인자 3개를 받는 sum함수값 sum3에 대입
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.0f\n\n", "폴리융", 100, 100, 100, sum3, cc2.avg(sum3, 3)); // 합과 평균 출력
		
		System.out.printf("4월 성적표\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		System.out.printf("이름\t국어\t영어\t수학\t과학\t총정\t평균\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		int sum4 = cc2.sum(100, 100, 100, 100); // cc2 인스턴스의 인자 4개를 받는 sum함수값 sum4에 대입
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%.1f\n\n", "폴리융", 100, 100, 100, 100, sum4, cc2.avg(sum4, 4)); // 합과 평균 출력
		
		System.out.printf("5월 성적표\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		System.out.printf("이름\t국어\t영어\t수학\t과학\t사회\t총정\t평균\n"); // 출력
		System.out.printf("===============================================================\n"); // 출력
		int sum5 = cc2.sum(100, 100, 100, 100, 100); // cc2 인스턴스의 인자 5개를 받는 sum함수값 sum5에 대입
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%.1f\n\n", "폴리융", 100, 100, 100, 100, 100, sum5, cc2.avg(sum5, 5)); // 합과 평균 출력

	}

}
