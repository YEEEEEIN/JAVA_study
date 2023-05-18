package Java_230404;

public class Java_0404_01 {

	public static void main(String[] args) {
		String k23_jumin = "123456-1234567"; // 변수 k23_jumin를 String 선언, 초기값 설정
		
		switch(k23_jumin.charAt(8)) { // switch case문
			case '1' : // k23_jumin.charAt(8)가 1일 때
				System.out.printf("20세기 전 태어난 남자 사람\n"); // 출력
			case '2' : // k23_jumin.charAt(8)가 2일 때
				System.out.printf("20세기 전 태어난 여자 사람\n"); // 출력
			case '3' : // k23_jumin.charAt(8)가 3일 때
				System.out.printf("20세기 후 태어난 남자 사람\n"); // 출력
			case '4' : // k23_jumin.charAt(8)가 4일 때
				System.out.printf("20세기 후 태어난 여자 사람\n"); // 출력
			default : // k23_jumin.charAt(8)가 1~4가 아닐 때
				System.out.printf("사람\n"); // 출력
				break; // switch문을 빠져나온다
		}

	}

}
