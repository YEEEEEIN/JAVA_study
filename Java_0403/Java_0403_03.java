package Java_0403;

public class Java_0403_03 {
	public static int k23_netprice(int k23_price, double k23_rate) { // 세전가격(상품가격, 세율)
		return (int) (k23_price / (1 + k23_rate)); // 세전가격의 정수형 반환(낮게)
	}

	public static void main(String[] args) {
		int k23_price = 1234; // 상품 가격
		double k23_tax_rate = 0.1; // 세율

		int k23_netprice = k23_netprice(k23_price, k23_tax_rate); // 좌변 netprice는 변수, 우변 netprice는 함수
		int k23_tax = k23_price - k23_netprice; // 세금 = 상품 가격 - 세금 가격
		
		//출력
		System.out.printf("***********************************************\n");
		System.out.printf("*        소비자가, 세전가격, 세금 계산        *\n");
		System.out.printf("소비자 가격 : %d, 세전가격 : %d, 세금 : %d\n", k23_price, k23_netprice, k23_tax);
		System.out.printf("***********************************************\n");
	}
}
