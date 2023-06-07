package Java_230407;

public class P04 {
	public static void iamMethod() {
		System.out.println("메소드라 불러줘요~~\n");
	}

	public static void main(String[] args) {
		P04.iamMethod(); // 클래스명.메소드명이 원칙이지만

		iamMethod(); // 자기 클래스 안에 함수를 정의하면 함수이름만으로 불러올 수 있다.

	}

}
