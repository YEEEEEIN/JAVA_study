package Java_230403;

public class Java_0403_02 {

	public static int k23_taxcal(int k23_val, int k23_rate) { // 인자를 int형 k23_val(세전 물건 값), int형 k23_rate(세금 % 값)를 받는다
		int k23_ret; // int형 선언

		if (((double) k23_val * (double) k23_rate / 100.0) == k23_val * k23_rate / 100) { // double형으로 세금 계산한 값이 소숫점 없이 나누어 떨어지면
			k23_ret = k23_val * k23_rate / 100; // int형 값 그대로 출력
		} else { // int형과 다르면
			k23_ret = k23_val * k23_rate / 100 + 1; // int형 값+ 1을 출력
		}
		return k23_ret; // k23_ret 값을 반환
	}

	public static void main(String[] args) {

		int k23_val = 271; // 세전 물건 값
		int k23_rate = 3; // 세금 3퍼센트

		int k23_tax = k23_taxcal(k23_val, k23_rate); // 인자 k23_val, k23_rate을 받아서 k23_taxcal 함수 계산

		System.out.printf("*******************************************\n");
		System.out.printf("*             단순 세금 계산             *\n");
		System.out.printf("*실제 세금 계산 : %f\n", k23_val * k23_rate / 100.0); // double형 실제 세금 금액 출력
		System.out.printf("*세전가격 : %d, 세금 : %d, 세포함가격 : %d\n", k23_val, k23_tax, k23_val + k23_tax); // 세전가격, 세금가격, 세전가격+세금가격 출력																					
		System.out.printf("*******************************************\n");

	}

}
