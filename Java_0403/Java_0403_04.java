package Java_0403;

public class Java_0403_04 {

	public static void main(String[] args) {
		String[] k23_item = { "맛동산", "웨하스", "롯데샌드", "오땅", "사브레" }; // k23_item 변수 문자열 배열 및 초기값 선언
		int[] k23_price = { 1000, 2000, 3000, 2500, 1450 }; // k23_item 변수 문자열 배열 및 초기값 선언
		int[] k23_amount = { 10, 2, 1, 3, 5 }; // k23_amount 변수 정수형 배열 및 초기값 선언
		double k23_tax_rate = 0.1; // k23_tax_rate 변수 더블형 및 초기값 선언
		int k23_total_sum = 0; // k23_total_sum 변수 정수형 및 초기값 선언
		//
		System.out.printf("*************************************************\n");
		System.out.printf("*\t\t   너가 산 과자들   \t\t*\n");
		System.out.printf("    항 목          단 가     수 량\t    합 계\n");
		System.out.printf("*************************************************\n");
		for (int k23_i = 0; k23_i < k23_item.length; k23_i++) { // k23_item.length = 5, i(0 ~ 4) 반복
			int k23_sum = k23_price[k23_i] * k23_amount[k23_i]; // 합은 가격 * 수량
			k23_total_sum = k23_total_sum + k23_sum; // 총합 = 합의 누적
			System.out.printf("%5s  \t%7d\t\t%2d\t%9d\n", k23_item[k23_i], k23_price[k23_i], k23_amount[k23_i], k23_sum); // 각 과자의 이름, 가격, 수량, 합 출력																									
		}
		System.out.printf("*************************************************\n");
		System.out.printf(" 지불 금액 :\t\t%25d\n", k23_total_sum);

		int k23_total_net_price = (int) (k23_total_sum / (1 + k23_tax_rate)); // 총 과세금액 = 지불 금액 * 1.1 
		System.out.printf(" 과세 금액 :\t\t%25d\n", k23_total_net_price); 
		int k23_tax = k23_total_sum - k23_total_net_price; // 세금 = 지불금액 - 과세금액
		System.out.printf(" 세금 :\t\t%33d\n", k23_tax);

	}

}
