package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_07 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // DecimalFormat 객체 생성하여 돈 단위 형식 지정
		LocalDateTime now = LocalDateTime.now(); // LocalDateTime 객체 생성하여 현재시간 불러오기
		String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy/MM/dd HH:mm:ss"))); // 형식에 맡는 시간 대입

		int price = 67200; // 소비자가 대입
		double vatRate = 0.1; // 부가세율 0.1 대입

		// 과세합계
		double calTax = price / (vatRate + 1.0); // 소비자가 / 1.1을 double형 과세합계에 대입
		// 계산할 때 double형으로 맞춰 계산해서 소숫점의 손실을 막아준다
		// 강제형변환 할 경우 소수점이 손실되어 계산결과가 오류가 나타날 때가 많음

		// 부가세
		double vatprice = calTax * vatRate; // double형 과세합계 * double형 부가세율을 double형 부가세에 대입
		int ivatprice = (int) Math.ceil(vatprice); // 부가세는 항상 높게 받아야하기 때문에 올림처리 후 정수형 변환하여 대입

		// 찐과세합계
		int realCalTax = price - ivatprice; // 찐 과세합계 = 소비자가 - 부가세

		System.out.printf("신용승인\n"); // 정보 출력
		System.out.printf("%s%18s\n", "단말기 : 2N68665898", "전표번호 : 041218"); // 정보 출력
		System.out.printf("가맹점 : 한양김치찌개\n"); // 정보 출력
		System.out.printf("주  소 : 경기 성남시 분당구 황새울로351번길 10 , 1층\n"); // 정보 출력
		System.out.printf("대표자 : 유창신\n"); // 정보 출력
		System.out.printf("%s%20s\n", "사업자 : 752-53-00558", "TEL : 7055695"); // 정보 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력
		System.out.printf("%s%33s원\n", "금  액", df.format(realCalTax)); // 금액 형식에 맞게 출력
		System.out.printf("%s%33s원\n", "부가세", df.format(ivatprice)); // 부가세 형식에 맞게 출력
		System.out.printf("%s%33s원\n", "합  계", df.format(price)); // 합계 형식에 맞게 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력

		System.out.printf("우리카드\n"); // 정보 출력
		System.out.printf("카드번호 : 5387-20**-****-4613(S)  일시불\n"); // 정보 출력
		System.out.printf("거래일시 : %s\n", NowTime); // 현재시간 형식에 맞게 출력
		System.out.printf("승인번호 : 70404427\n"); // 정보 출력
		System.out.printf("거래번호 : 357734873739\n"); // 정보 출력
		System.out.printf("매입 : 비씨카드사    가맹 : 720068568\n"); // 정보 출력
		System.out.printf("알림 : EDC매출표\n"); // 정보 출력
		System.out.printf("문의 : TEL)1544-4700\n"); // 정보 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력
		System.out.printf("%22s\n", "*감사합니다*"); // 정보 출력
		System.out.printf("%39s\n", "표준v2.08_20200212"); // 정보 출력

	}

}
