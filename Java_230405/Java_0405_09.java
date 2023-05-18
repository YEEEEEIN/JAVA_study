package Java_230405;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Java_0405_09 {
	
	public static String[] itemNames = { "마요네스 500g X 2입", "(G)LH프리미엄원형유리화병", "꼬북칩 초코맛인절미맛과자E", "나일론 블랙양말(구멍이 안나요!)",
			"해피홈 SAFE 핸드워시", "농심 신라면120g*5", "(대)국내산삼겹살찌개", "오뚜기 진비빔면 156g", "GAP 유기농 죽장사과 4-6입", "순 유기농 바나나맛 우유",
			"피코크 탄두리 닭가슴살", "BHC 뿌링클맛 볶음라면", "DZ주니어양말3족C_BK", "프리미엄 연어공주 광어왕자초밥", "1+등급란 10개입 특",
			"(매콤달콤)순살닭강정(200g*5)", "LG 스마트 스타일러2023", "동원양반볶음묵은지김치기획", "CJ 비비고칩 200G", "공차 말차 밀크티 20번들",
			"피코크 들깨미역국", "오뚜기 골드 마요네스 500g X 2입", "다우니 초고농축 섬유유연제 4L (퍼플 화이트티와 릴리 향)", "배스킨 엄마는 외계인 초코볼 192g",
			" LG전자 통돌이 세탁기", "비오는 날엔 김치치즈스마일부침개~", "노브랜드 국산콩두부300g*2입", "종가집 행복이온 전라도포기김치10kg", "이맛쌀 10kg_상등급",
			"제주삼다수 그린 2L 6병" }; // itemNames String형 배열 선언 및 대입
	
	public static int[] price = { 1872, 8250, 2400, 12600, 15400, 6400, 18500, 4600, 24500, 6510, 22000, 3100, 23000, 24620, 6400,
			12000, 215640, 1007800, 3450, 156600, 610, 7320, 21270, 10800, 372495, 2450, 3280, 48900, 29900, 6480 }; 
	// price int형 배열 선언 및 대입
	public static int[] num = { 6, 1, 3, 4, 2, 2, 1, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 2, 2, 1, 1, 1, 1, 10, 1, 1, 1, 2, 1, 1 };
	// num int형배열 선언 및 대입
																												
	public static boolean[] taxFree = { true, true, false, false, false, true, true, false, true, false, false, false, false,
			true, false, true, false, false, true, false, false, true, true, false, false, false, true, false,
			false, true }; // taxFree boolean형 배열 선언 및 대입

	// 세금 계산 (당연히 과세물품만)
	public static int netprice(int price, double rate) { // 정수형 소비자가, 더블형 세율을 대입해 과세물품가을 출력
		return (int) (price / (1 + rate)); // 소비자가/ (1+세율)을 정수형으로 받아 소수점 자리 내림
											// -> 과세물품가 적게 출력 -> 부가세 높게 출력하기 위해
	}

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar 클래스를 통해 인스턴스 생성
		Calendar cal2 = Calendar.getInstance(); // Calendar 클래스를 통해 인스턴스 생성
		Date date = new Date(); // Date 클래스를 통해 인스턴스 생성
		cal2.setTime(date); // 현재 날짜를 설정
		cal2.add(Calendar.HOUR, -2); // 시간을 2시간 전을 설정

		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 현재시간 출력 형식 지정
		SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyyMMdd"); // 현재시간 출력 형식 지정
		SimpleDateFormat dateFormatter3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 현재시간 출력 형식 지정
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 돈 단위 형식 지정

		String[] itemNames = { "마요네스 500g X 2입", "(G)LH프리미엄원형유리화병", "꼬북칩 초코맛인절미맛과자E", "나일론 블랙양말(구멍이 안나요!)",
				"해피홈 SAFE 핸드워시", "농심 신라면120g*5", "(대)국내산삼겹살찌개", "오뚜기 진비빔면 156g", "GAP 유기농 죽장사과 4-6입", "순 유기농 바나나맛 우유",
				"피코크 탄두리 닭가슴살", "BHC 뿌링클맛 볶음라면", "DZ주니어양말3족C_BK", "프리미엄 연어공주 광어왕자초밥", "1+등급란 10개입 특",
				"(매콤달콤)순살닭강정(200g*5)", "LG 스마트 스타일러2023", "동원양반볶음묵은지김치기획", "CJ 비비고칩 200G", "공차 말차 밀크티 20번들",
				"피코크 들깨미역국", "오뚜기 골드 마요네스 500g X 2입", "다우니 초고농축 섬유유연제 4L (퍼플 화이트티와 릴리 향)", "배스킨 엄마는 외계인 초코볼 192g",
				" LG전자 통돌이 세탁기", "비오는 날엔 김치치즈스마일부침개~", "노브랜드 국산콩두부300g*2입", "종가집 행복이온 전라도포기김치10kg", "이맛쌀 10kg_상등급",
				"제주삼다수 그린 2L 6병" }; // itemNames String형 배열 선언 및 대입
		
		int[] price = { 1872, 8250, 2400, 12600, 15400, 6400, 18500, 4600, 24500, 6510, 22000, 3100, 23000, 24620, 6400,
				12000, 215640, 1007800, 3450, 156600, 610, 7320, 21270, 10800, 372495, 2450, 3280, 48900, 29900, 6480 }; 
		// price int형 배열 선언 및 대입
		int[] num = { 6, 1, 3, 4, 2, 2, 1, 1, 2, 3, 1, 3, 1, 1, 3, 1, 1, 2, 2, 1, 1, 1, 1, 10, 1, 1, 1, 2, 1, 1 };
		// num int형배열 선언 및 대입
																													
		boolean[] taxFree = { true, true, false, false, false, true, true, false, true, false, false, false, false,
				true, false, true, false, false, true, false, false, true, true, false, false, false, true, false,
				false, true }; // taxFree boolean형 배열 선언 및 대입

		int taxFreePrice = 0; // 면세 물품 소비자가
		int taxPrice = 0; // 과세 물품 소비자가(부가세 포함)
		int total_price = 0; // 전체 소비자가 = 면세 물품 소비자가 + 과세 물품 소비자가
		double vatRate = 0.1; // 세금율

		// 영수증 출력부
		System.out.printf("%13s이마트 죽전점 (031)888-1234\n", ""); // 영수증 정보 출력
		System.out.printf("%13s206-86-50913 강희석\n", ""); // 영수증 정보 출력
		System.out.printf("%s", "emart"); // 영수증 정보 출력
		System.out.printf("%8s용인 수지구 포은대로 552\n", ""); // 영수증 정보 출력
		System.out.printf("영수증 미지참시 교환/환불 불가\n"); // 영수증 정보 출력
		System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n"); // 영수증 정보 출력
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n"); // 영수증 정보 출력
		System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n\n"); // 영수증 정보 출력
		System.out.printf("[구매]%s%19s\n", dateFormatter1.format(cal.getTime()), "POS:0011-9861"); // 현재 시간 형식에 맞게 출력
		System.out.printf("-----------------------------------------\n"); // 출력
		System.out.printf("%7s%11s%6s%9s", "상 품 명", "단  가", "수량", "금  액\n"); // 영수증 정보 출력

		// 품목 출력부
		for (int i = 0; i < itemNames.length; i++) { // i는 0부터 itemNames배열의 길이 전까지 1씩 증가
			String cc = cutString(itemNames[i], 14); // cutString 함수를 사용해 itemNames[i]을 잘라서 String cc에 대입

			if (i % 5 == 0) { // i 나누기 5의 나머지가 0이면 (5개마다 구분선 출력되게 하려고)
				System.out.printf("-----------------------------------------\n"); // 구분선 출력
			}

			if (taxFree[i] == true) { // 면세
				System.out.printf("* %s%11s%3d%11s\n", cc, df.format(price[i]), num[i], df.format(price[i] * num[i]));
				// 품목, 가격, 수, 합 출력
				taxFreePrice += num[i] * price[i]; // 면세 물품 소비자가 누적

			} else { // 과세
				System.out.printf("  %s%11s%3d%11s\n", cc, df.format(price[i]), num[i], df.format(price[i] * num[i]));
				// 품목, 가격, 수, 합 출력
				taxPrice += num[i] * price[i]; // 과세물품 소비자가 누적(부가세 포함)
			}

			total_price = taxFreePrice + taxPrice; // 총 면세 물품 소비자가 + 총 과세물품 소비자가
		}

		int netprice = netprice(taxPrice, vatRate); // 과세물품
		int vatPrice = taxPrice - netprice; // 부가세
		int point = 5473; // 기존 포인트
		int plusPoint = (int) (total_price * 0.001); // 적립될 포인트

		System.out.printf("\n%15s총 품목 수량 %13d\n", "", itemNames.length); // 품목 수량 출력
		System.out.printf("%11s (*)면 세  물 품 %13s\n", "", df.format(taxFreePrice)); // 면세 물품 소비자가 출력
		System.out.printf("%15s과 세  물 품 %13s\n", "", df.format(netprice)); // 과세물품 소비자가 출력
		System.out.printf("%15s부   가   세 %13s\n", "", df.format(vatPrice)); // 부가세 출력
		System.out.printf("%15s합        계 %13s\n", "", df.format(total_price)); // 소비자가 총 합 출력
		System.out.printf("결 제 대 상 금 액 %23s\n", df.format(total_price)); // 소비자가 총 합 출력
		System.out.printf("-----------------------------------------\n"); // 출력
		System.out.printf("0012 KEB 하나       541707**0484/35860658\n"); // 정보 출력
		System.out.printf("카드결제(IC)           일시불 /%10s\n", df.format(total_price)); // 소비자가 총 합 출력
		System.out.printf("-----------------------------------------\n"); // 출력
		System.out.printf("           [신세계포인트 적립]\n"); // 출력
		System.out.printf("홍*두 고객님의 포인트 현황입니다.\n"); // 출력
		System.out.printf("금회발생포인트      9350**9995 %10s\n", df.format(plusPoint)); // 적립될 포인트 출력
		System.out.printf("누계(가용)포인트   %10s(%10s)      \n", df.format(point + plusPoint), df.format(point)); // 적립될
																												// 포인트+기존
																												// 포인트,
																												// 기존
																												// 포인트
																												// 출력
		System.out.printf("*신세계포인트 유효기간은 2년입니다.\n"); // 출력
		System.out.printf("-----------------------------------------\n"); // 출력
		System.out.printf("   구매금액기준 무료주차시간 자동부여   \n"); // 출력
		System.out.printf("차량번호 :                       34저****\n"); // 출력
		System.out.printf("입차시간 :            %s\n", dateFormatter3.format(cal2.getTime())); // 현재시간 2시간 전 출력
		System.out.printf("-----------------------------------------\n"); // 출력
		System.out.printf("캐셔:084599 양00                     1150\n"); // 출력
		System.out.println("\n"); // 개행
		System.out.printf("      %s/00119861/00164980/31\n", dateFormatter2.format(cal.getTime())); // 현재시간 출력

	}

	public static String cutString(String str, int len) {
		// 문자열(str)을 입력받아
		// 길이가 14 이하이면 오른쪽에 공백을 채워서 14자로 만들어주고,
		// 14자를 초과하면 문자열을 잘라서 반환해주는 기능
		byte[] by = str.getBytes(); // 문자열을 byte 배열로 변환합니다.
		if (by.length <= 14) { // 만약 문자열의 길이가 14 이하이면
			str = new String(by, 0, by.length); // 바이트 배열(by)을 문자열(str)로 변환
			for (int i = by.length; i < 14; i++) { // 길이가 14가 되도록
				str = str + " "; // 문자열 뒤에 공백을 추가
			}
			return str; // 그 결과를 반환
		} else { // 만약 문자열의 길이가 14보다 크면
			int count = 0; // count 초기화
			try {
				for (int i = 0; i < len; i++) { // 바이트 배열의 길이(len)만큼 반복문 실행
					if ((by[i] & 0x80) == 0x80) // 바이트의 최상위 비트가 1인지 확인
						count++; // count 1 증가(핵심코드)
				}
				if ((by[len - 1] & 0x80) == 0x80 && (count % 2) == 1) { // 바이트 배열의 마지막 바이트가 최상위 비트가 1이고 count가 홀수인 경우
					len--; // 바이트 배열의 길이(len)를 1 줄임(핵심코드)
					String str1 = new String(by, 0, len) + " "; // 새로운 문자열 생성
					return str1;// 새로운 문자열 반환
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) { // 예외 처리
				System.out.println(e);
				return "";
			}
			String str2 = new String(by, 0, len); // 바이트 배열 전체를 문자열로 변환
			return str2; // 문자열 반환
		}
	}
}
