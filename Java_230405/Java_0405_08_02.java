package Java_230405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java_0405_08_02 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("###,###,###,###"); // 형식 지정
		LocalDateTime now = LocalDateTime.now(); // 현재 시간 구하기
		LocalDate currentDate = LocalDate.now(); // 현재 날짜 구하기
		// 14일을 더한 날짜 구하기
		LocalDate futureDate = currentDate.plusDays(14);
		// 원하는 형식으로 날짜 출력하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월dd일");
		String result = futureDate.format(formatter);
		String NowTime = now.format(DateTimeFormatter.ofPattern(("yyyy.MM.dd HH:mm:ss")));

		// itemNames String형 배열 선언 및 대입
		String[] itemNames = { "퓨어에어 비말차단용마스크(최고급형)", "슬라이드식명찰(가로형)(100호)", "매직흡착 인테리어후크(알루미늄타입)" };
		int[] itemcode = { 1031615, 11008152, 1020800 }; // itemcode int형 배열 선언 및 대입
		int[] prices = { 3000, 1000, 1000 }; // prices int형 배열 선언 및 대입
		int[] num = { 1, 1, 1 }; // num int형 배열 선언 및 대입

		// 출력부
		System.out.printf("%23s\n", "\"국민가게, 다이소\""); // 정보 출력

		System.out.printf("(주)아성다이소_분당서현점\n"); // 정보 출력
		System.out.printf("전화:031-702-6016\n"); // 정보 출력
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n"); // 정보 출력
		System.out.printf("대표:박정부,신호섭 213-81-52063\n"); // 정보 출력
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 (서현동)\n"); // 정보 출력

		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // 출력
		System.out.printf("%24s\n", "소비자중심경영(CCM) 인증기업"); // 정보 출력
		System.out.printf("%26s\n", "ISIO 9001 품질경영시스템 인증기업"); // 정보 출력
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // 정보 출력
		System.out.printf("%6s교환/환불 14일(%s)이내,\n", "", result); // 14일 이후 MM월dd일 출력
		System.out.printf("(전자)영수증. 결제카드 지참 후 구입매장에서 가능\n"); // 정보 출력
		System.out.printf("%23s\n", "포장/가격 택 훼손시 교환/환불 불가"); // 정보 출력
		System.out.printf("%23s\n", "체크카드 취소 시 최대 7일 소요"); // 정보 출력
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // 출력
		System.out.printf("[PDS 1058231] %27s\n", NowTime); // 현재-시간 출력
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // 정보 출력

		int sum = 0; // 소비자가합 int형 정의, 초기값 설정

		// 품목 출력부
		for (int i = 0; i < itemNames.length; i++) { // i는 0부터 itemNames배열의 길이 전까지 1씩 증가
			String cc = cutString(itemNames[i], 20); // cutString 함수를 사용해 itemNames[i]을 잘라서 String cc에 대입
			System.out.printf("%s%8s%3d%10s\n", cc, df.format(prices[i]), num[i], df.format(prices[i] * num[i])); // 품목,
																													// 가격,
																													// 수,
																													// 합
																													// 출력
			System.out.printf("[%d]\n", itemcode[i]); // 코드번호 출력

			sum += num[i] * prices[i]; // 소비자가 누적
		}

		// 세금 10 퍼센트
		double vatRate = 0.1; // 부가세율 0.1 대입

		// 과세합계
		double calTax = sum / (vatRate + 1.0); // 소비자가 / 1.1을 double형 과세합계에 대입
		// 계산할 때 double형으로 맞춰 계산해서 소숫점의 손실을 막아준다
		// 강제형변환 할 경우 소수점이 손실되어 계산결과가 오류가 나타날 때가 많음

		// 부가세
		double vatprice = calTax * vatRate; // double형 과세합계 * double형 부가세율을 double형 부가세에 대입
		int ivatprice = (int) Math.ceil(vatprice); // 부가세는 항상 높게 받아야하기 때문에 올림처리 후 정수형 변환하여 대입

		// 찐과세합계
		int realCalTax = sum - ivatprice; // 찐 과세합계 = 소비자가 - 부가세

		System.out.printf("%19s%18s\n", "과세합계", df.format(realCalTax)); // 과세합계 출력
		System.out.printf("%20s%18s\n", "부가세", df.format(ivatprice)); // 부가세 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력
		System.out.printf("%s%33s\n", "판매합계", df.format(sum)); // 소비자가 합 출력
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n"); // 출력
		System.out.printf("%s%33s\n", "신용카드", df.format(sum)); // 소비자가 합 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력
		System.out.printf("%s%33s\n", "우리카드", "538720**********"); // 정보 출력
		System.out.printf("%s%17s\n", "승인번호 77982843(0)", "승인금액 " + df.format(sum)); // 소비자가 합 출력
		System.out.printf("= = = = = = = = = = = = = = = = = = = = =\n");
		System.out.printf("%25s 분당서현점\n", NowTime); // 현재시간 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400\n"); // 정보 출력
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n"); // 정보 출력
		System.out.printf("%28s\n", "2112820610158231"); // 정보 출력

		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n"); // 출력
		System.out.printf("◈다이소 멤버십 앱 또는 홈페이지에 접속하셔서\n"); // 출력
		System.out.printf("  회원가입 후 다양한 혜택을 누려보세요! ◈\n"); // 출력

	}

	public static String cutString(String str, int len) {
		// 문자열(str)을 입력받아
		// 길이가 14 이하이면 오른쪽에 공백을 채워서 14자로 만들어주고,
		// 14자를 초과하면 문자열을 잘라서 반환해주는 기능
		byte[] by = str.getBytes(); // 문자열을 byte 배열로 변환합니다.
		if (by.length <= 21) { // 만약 문자열의 길이가 14 이하이면
			str = new String(by, 0, by.length); // 바이트 배열(by)을 문자열(str)로 변환
			for (int i = by.length; i < 21; i++) { // 길이가 14가 되도록
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
