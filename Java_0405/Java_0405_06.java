package Java_0405;

public class Java_0405_06 {

	public static void main(String[] args) {
		int iWeekday = 5; // 1월 1일이 금요일부터 시작 가정
		// iWeekday = 0(일), 1(월), 2(화), 3(수), 4(목), 5(금), 6(토) => 일수의 위치
		int[] iEnd = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 1~12월 일 수 배열 생성

		for (int iMon = 0; iMon < 12; iMon++) { // 매월 0~11월까지
			System.out.printf("\n\n\t\t\t%d월\n", iMon + 1); // 월을 0부터 시작으로 잡기 때문에 +1을 해준다
			System.out.printf("==================================================\n"); // 출력
			System.out.printf(" 일\t월\t화\t수\t목\t금\t토\n"); // 요일 출력

			int dayOfWeek = iWeekday; // iWeekday를 dayOfWeek에 대입
			for (int day = 1; day <= iEnd[iMon]; day++) { // 1일부터 해당 월 배열에 들어있는 일수 만큼 1씩 증가하면서 출력

				// 달의 첫번째 day까지 공간 출력
				if (day == 1) { // day가 매 달의 첫 날이면
					for (int i = 0; i < dayOfWeek; i++) { // 일수의 위치 전까지
						System.out.print("\t"); // 공백 출력
					}
				}
				
				System.out.printf("%2d\t", day); // day 출력

				if (dayOfWeek == 6) { // dayOfWeek가 6이면 = 토요일
					System.out.print("\n"); // 개행 -> 일주일이 바뀌기 때문에
				}

				// 일요일로 바꿔주기
				dayOfWeek = (dayOfWeek + 1) % 7; // 다음 주로 바꿔주기 dayOfWeek는 0부터 시작
			}

			if (dayOfWeek != 0) { // 마지막 날의 위치가 0이 아니면 => 토요일이 아니면
				System.out.print("\n"); // 개행 -> 다음달 새로 시작
			}

			iWeekday = (iWeekday + iEnd[iMon]) % 7; // 다음 달 시작 일 설정
		}

	}

}
