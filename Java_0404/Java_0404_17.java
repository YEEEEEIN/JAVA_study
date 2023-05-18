package Java_0404;

import java.text.DecimalFormat;

public class Java_0404_17 {

	public static void main(String[] args) {
		// 칸 맞추기 연습

		String k23_item = "사과"; // 변수 k23_item을 String 정의, 초기화
		int k23_unit_price = 5000; // 변수 k23_unit_price을 int 정의, 초기화
		int k23_num = 500; // 변수 k23_num을 int 정의, 초기화
		int k23_total = 0; // 변수 k23_total을 int 정의, 초기화

		DecimalFormat k23_df = new DecimalFormat("###,###,###,###,###");
		// DecimalFormat 클래스를 통해 인스턴스 생성, 형식 주어짐

		// 해더 찍기
		System.out.printf("========================================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목", "단가", "수량", "합계");
		// %20.20s : 문자열 출력을 위한 형식지정자
		// 앞 20은 출력할 필드의 폭, 뒤 20은 출력할 문자의 최대 길이
		System.out.printf("========================================================\n");

		// 값 찍기
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n", k23_item, k23_df.format(k23_unit_price),
				k23_df.format(k23_num), k23_df.format(k23_unit_price * k23_num));
		// 품목, 단가, 수량, 합계 출력
	}

}
