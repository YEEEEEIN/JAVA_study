package Java_230403;

import java.text.DecimalFormat; // DecimalFormat 클래스 호출
import java.text.SimpleDateFormat; // SimpleDateFormat 클래스 호출
import java.util.Calendar; // Calendar 클래스 호출

public class Java_0403_05 {

	public static void main(String[] args) {
		// 수수료 없이 계산
		int k23_MyWon = 1000000; // 환전할 금액, 정수형 및 초기값 선언
		double k23_MoneyEx = 1238.21; // 달러 환율, 더블형 및 초기값 선언
		double k23_commission = 0.003; // 환전 수수료, 더블형 및 초기값 선언

		int k23_usd = (int) (k23_MyWon / k23_MoneyEx); // 환전한 달러, 최종 결과를 정수형으로 만들면 버림 처리
		int k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx); // 남은 돈 = 환전할 금액 - 환전한 금액

		// 출력
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			수수료 없이 계산 			*\n");
		System.out.printf("총 환화환전금액: %d원 => 미화: %d달러, 잔돈: %d원\n", k23_MyWon, k23_usd, k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// 수수료 계산
		double k23_ComPerOne = k23_MoneyEx * k23_commission; // 1달러 당 수수료, double형으로 선언하여 소수점까지 받는다.

		double k23_totalcom = k23_usd * k23_ComPerOne; // 총 수수료, 달러 * 1달러 당 수수료

		// 출력
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			수수료 계산 			*\n");
		System.out.printf("총 수수료: %f원 => 미화: %d달러, 달러당 수수료: %f원\n", k23_totalcom, k23_usd, k23_ComPerOne);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// 수수료 적용환전
		int k23_i_totalcom; // k23_i_totalcom 환전 수수료 정수형 선언 -> 수수료는 당연히 받아야 할 돈이니 올림 처리

		if (k23_totalcom != (double) ((int) k23_totalcom)) { // double형으로 수수료 계산한 값이 소숫점이 있으면
			k23_i_totalcom = (int) k23_totalcom + 1; // 올림으로 처리해야하기 때문에 수수료 + 1
		} else { // double형으로 수수료 계산한 값이 소숫점 없이 나누어 떨어지면
			k23_i_totalcom = (int) k23_totalcom; // 수수료
		}

		// 출력
		System.out.printf("*********************************************************************\n"); // 출력
		System.out.printf("*			수수료 적용환전 			*\n");
		System.out.printf("총 수수료: %d원 => 미화: %d달러, 달러당 수수료: %f원\n", k23_i_totalcom, k23_usd, k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom); // 잔돈 = 환전할 금액 - 환전한 금액 - 환전 수수료

		// 출력
		System.out.printf("총 한화환전금액: %d원 => 미화: %d달러, 수수료청구: %d원, 잔돈: %d원\n", k23_MyWon, k23_usd, k23_i_totalcom, 
				k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// (정확한) 수수료 적용환전
		k23_usd = (int) (k23_MyWon / (k23_MoneyEx + k23_ComPerOne)); // 환전한 달러 = 환전할 달러 / ( 달러 환율 + 1달러 당 수수료) 의 정수형
		k23_totalcom = k23_usd * k23_ComPerOne;

		// 수수료 올림처리
		if (k23_totalcom != (double) ((int) k23_totalcom)) { // double형으로 수수료 계산한 값이 소숫점이 있으면
			k23_i_totalcom = (int) k23_totalcom + 1; // 올림으로 처리해야하기 때문에 수수료 + 1
		} else { // double형으로 수수료 계산한 값이 소숫점 없이 나누어 떨어지면
			k23_i_totalcom = (int) k23_totalcom; // 수수료
		}

		// 출력
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			(정확한)수수료 적용환전 			*\n");
		System.out.printf("총 수수료: %d원 => 미화: %d달러, 달러당 수수료: %f원\n", k23_i_totalcom, k23_usd, k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom); // 잔돈 = 환전할 금액 - 환전한 금액 - 환전 수수료

		// 출력
		System.out.printf("총 한화환전금액: %d원 => 미화: %d달러, 수수료청구: %d원, 잔돈: %d원\n", k23_MyWon, k23_usd, k23_i_totalcom,
				k23_remain);
		System.out.printf("*********************************************************************\n");
		System.out.printf("\n\n");

		// 콤마찍기, 날짜 적용
		DecimalFormat k23_df = new DecimalFormat("###,###,###,###,###"); // DecimalFormat 클래스를 통하여 인스턴스 생성

		// 출력
		System.out.printf("*********************************************************************\n");
		System.out.printf("*			콤마찍기, 날짜 적용 			*\n");
		System.out.printf("총 수수료: %s원 => 미화: %s달러, 달러당 수수료: %f원\n", k23_df.format(k23_i_totalcom),
				k23_df.format(k23_usd), k23_ComPerOne);

		k23_remain = (int) (k23_MyWon - k23_usd * k23_MoneyEx - k23_i_totalcom);
		System.out.printf("총 한화환전금액: %s원 => 미화: %s달러, 수수료청구: %s원, 잔돈: %s원\n", k23_df.format(k23_MyWon),
				k23_df.format(k23_usd), k23_df.format(k23_i_totalcom), k23_df.format(k23_remain));

		Calendar k23_calt = Calendar.getInstance(); // Calendar 클래스를 통하여 인스턴스 생성
		SimpleDateFormat k23_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // SimpleDateFormat 클래스를 통하여 인스턴스 생성
		System.out.printf("최종실행시간: %s\n", k23_sdt.format(k23_calt.getTime())); // k23_calt을 통해 시간을 가져와서 k23_sdt을 통해 지정한 형식으로 출력
		System.out.printf("*********************************************************************\n");

	}

}
