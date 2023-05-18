package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_08_01 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 형식 지정
		LocalDateTime now = LocalDateTime.now(); //  현재 시간 구하기
		LocalDate currentDate = LocalDate.now(); // 현재 날짜 구하기
		// 14일을 더한 날짜 구하기
        LocalDate futureDate = currentDate.plusDays(14);
        // 원하는 형식으로 날짜 출력하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월dd일");
        String result = futureDate.format(formatter);
		
	    String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy/MM/dd HH:mm:ss")));
	    // 품목
	    String itemname1 = "퓨어에어 비말차단용마스크(최고급형)";
	    byte [] aa = itemname1.getBytes();
	    String aa_itemname1 = new String(aa, 0, 26);
	    String itemcode1 = "1031615";
	    int price1= 3000;
	    int amount1 = 1;
	    int total1 = price1 * amount1;
	    
	    String itemname2 = "슬라이드식명찰(가로형)(100호)";
	    byte [] bb = itemname2.getBytes();
	    String bb_itemname2 = new String(bb, 0, 26);
	    String itemcode2 = "11008152";
	    int price2= 1000;
	    int amount2 = 1;
	    int total2 = price2 * amount2;
	    
	    String itemname3 = "매직흡착 인테리어후크(알루미늄타입)";
	    byte [] cc = itemname3.getBytes();
	    String cc_itemname3 = new String(cc, 0, 26);
	    String itemcode3 = "1020800";
	    int price3= 1000;
	    int amount3 = 1;
	    int total3 = price3 * amount3;
	    
	    // 총합
	    int totalAll =  total1 +  total2 +  total3; // 판매합계
	    double rateVat = 0.1; // 부가세율
	    double price_not_vat = totalAll / (1 + rateVat); // 과세합계
	    double priceVat = totalAll - price_not_vat; // 부가세
	   
		// 출력부
		System.out.printf("%23s\n", "\"국민가게, 다이소\"");
	
		System.out.printf("(주)아성다이소_분당서현점\n");
		System.out.printf("전화:031-702-6016\n");
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n");
		System.out.printf("대표:박정부,신호섭 213-81-52063\n");
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 (서현동)\n");
		
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%24s\n", "소비자중심경영(CCM) 인증기업");
		System.out.printf("%26s\n", "ISIO 9001 품질경영시스템 인증기업");
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%6s교환/환불 14일(%s)이내,\n", "", result); // 날짜 바꾸기
		
		System.out.printf("(전자)영수증. 결제카드 지참 후 구입매장에서 가능\n");
		System.out.printf("%23s\n", "포장/가격 택 훼손시 교환/환불 불가");
		System.out.printf("%23s\n", "체크카드 취소 시 최대 7일 소요");
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("[PDS 1058231] %27s\n", NowTime );
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		
		System.out.printf("%s %2s %2s %2s\n", aa_itemname1, df.format(price1), df.format(amount1), df.format(total1));
		System.out.printf("[%s]\n", itemcode1);
		System.out.printf("%s %2s %2s %2s\n", bb_itemname2, df.format(price2), df.format(amount2), df.format(total2));
		System.out.printf("[%s]\n", itemcode2);
		System.out.printf("%s %2s %2s %2s\n", cc_itemname3, df.format(price3), df.format(amount3), df.format(total3));
		System.out.printf("[%s]\n", itemcode3);
		
		
		System.out.printf("%19s%18s\n","과세합계", df.format(price_not_vat));
		System.out.printf("%20s%18s\n","부가세", df.format(priceVat));
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("%s%33s\n","판매합계", df.format(totalAll));
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%s%33s\n","신용카드", df.format(totalAll));
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("%s%33s\n","우리카드", "538720**********");
		System.out.printf("%s%11s %s\n","승인번호 77982843(0)", "승인금액", df.format(totalAll));
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%25s 분당서현점\n", NowTime );
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n");
		System.out.printf("%28s\n", "2112820610158231");
		
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("◈다이소 멤버십 앱 또는 홈페이지에 접속하셔서 회원가입 후 다양한 혜택을 누려보세요! ◈\n");
		
		
		
//		// 세금 10 퍼센트
//				double vatRate = 0.1;
//				int calrate = 10;
//
//				// 과세합계
//				double calTax = sum / (vatRate + 1.0);
//
//				// 부가세
//				double netprice = calTax * calrate / 100;
//				int inetprice = (int) Math.ceil(netprice);
//
//				// 찐과세합계
//				int kk = sum - inetprice;
		
		
	
	
		

	}
	

	
	

}
