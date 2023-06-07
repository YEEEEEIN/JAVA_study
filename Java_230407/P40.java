package Java_230407;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P40 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar 클래스를 통해 인스턴스 생성
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 현재시간 출력 형식 지정

		int iPerson = 200; // 이 값을 주는 만큼 저장소 생성
		int pageOfPerson = 30; // 한 페이지에 출력되는 인원수

		InputData inData = new InputData(iPerson); // 생성자의 숫자를 준 만큼 배열을 만든다.

		for (int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1); // 이름 만들기
			int kor = (int) (Math.random() * 100); // 국어점수 만들기
			int eng = (int) (Math.random() * 100); // 영어점수 만들기
			int mat = (int) (Math.random() * 100); // 수학점수 만들기
			inData.SetData(i, name, kor, eng, mat); // 클래스 내 값 입력
		}

		int cnt = 0; // 1명 출력될 때 마다 세는 변수
		int page = 1; // 페이지 세는 변수
		int i = 0;
		int pageKor = 0; // 페이지마다 누적 국어점수 누적 합
		int pageEng = 0; // 페이지마다 누적 영어점수 누적 합
		int pageMat = 0; // 페이지마다 누적 수학점수 누적 합
		int pageSum = 0; // 페이지마다 누적 합계점수 누적 합
		int pageAvg = 0; // 페이지마다 누적 평균점수 누적 합
		
		while (cnt <  200) { // 200명 셀 때 까지 반복
			int korSum = 0; // 한 페이지에서만 국어점수 누적 합
			int engSum = 0; // 한 페이지에서만 영어점수 누적 합
			int matSum = 0; // 한 페이지에서만 수학점수 누적 합
			int sumSum = 0; // 한 페이지에서만 합계점수 누적 합
			double avgSum = 0; // 한 페이지에서만 평균점수 누적 합

			System.out.printf("                성적 집계표\n"); // 출력
			System.out.printf("PAGE: %d                    출력일자: %s\n", page, dateFormatter1.format(cal.getTime())); // 페이지, 출력일자 출력
			System.out.printf("=======================================================================\n"); // 출력
			System.out.printf("번호   이름     국어   영어   수학   총점     평균\n"); // 출력
			System.out.printf("=======================================================================\n"); // 출력
			
			// 입력된 값이 잘 들어갔는지 확인
			for (i = cnt; i < iPerson; i++) { // 지정한 인원 수 만큼 반복

				System.out.printf("%03d%8s%7d%7d%7d%7d%9.0f\n",
						i + 1, inData.name[i], inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
				// 번호, 이름, 국어점수, 영어점수, 수학점수, 합계, 평균 출력
				
				cnt++;
				
				korSum += inData.kor[i]; // 한 페이지에서만 누적하는 국어점수에 누적
				engSum += inData.eng[i]; // 한 페이지에서만 누적하는 영어점수에 누적
				matSum += inData.mat[i]; // 한 페이지에서만 누적하는 수학점수에 누적
				sumSum += inData.mat[i]; // 한 페이지에서만 누적하는 합계점수에 누적
				avgSum += inData.avg[i]; // 한 페이지에서만 누적하는 평균점수에 누적

				if (cnt % pageOfPerson == 0) { // 만약 횟수가 페이지당 인원수 나눈 나머지가 0이라면
					page++; // 페이지 +1 => 다음 페이지
					pageKor += korSum; // 페이지마다 누적 합에 한 페이지만 누적했던 국어점수 누적
					pageEng += engSum; // 페이지마다 누적 합에 한 페이지만 누적했던 영어점수 누적
					pageMat += matSum; // 페이지마다 누적 합에 한 페이지만 누적했던 수학점수 누적
					pageSum += sumSum; // 페이지마다 누적 합에 한 페이지만 누적했던 힙계점수 누적
					pageAvg += avgSum; // 페이지마다 누적 합에 한 페이지만 누적했던 평균점수 누적
					break; // for문 탈출
				}
				
			}

			System.out.printf("=======================================================================\n"); // 출력
			System.out.printf("현재페이지\n"); // 출력
			System.out.printf("합계%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum); // 한 페이지에서만 누적한 점수 출력
			System.out.printf("평균%16d%7d%7d%7d%9.0f\n", 
					korSum / iPerson, engSum / iPerson, matSum / iPerson, sumSum / iPerson, avgSum / iPerson); // 한 페이지에서만 누적한 점수의 평균 출력
			System.out.printf("=======================================================================\n");
			System.out.printf("누적페이지\n");
			System.out.printf("합계%16d%7d%7d%7d%9d\n", pageKor, pageEng, pageMat, pageSum, pageAvg); // 페이지마다 누적한 점수 출력
			System.out.printf("평균%16d%7d%7d%7d%9d\n\n\n",
					pageKor / cnt, pageEng / cnt, pageMat / cnt, pageSum / cnt, pageAvg / cnt);// 페이지 마다 누적한 점수의 평균 출력

		}
	}

}






/*
package PPT06;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P40 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar 클래스를 통해 인스턴스 생성
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 현재시간 출력 형식 지정

		int iPerson = 200; // 이 값을 주는 만큼 저장소 생성
		int pageOfPerson = 30; // 한 페이지에 출력되는 인원수

		InputData inData = new InputData(iPerson); // 생성자의 숫자를 준 만큼 배열을 만든다.

		for (int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1); // 이름 만들기
			int kor = (int) (Math.random() * 100); // 국어점수 만들기
			int eng = (int) (Math.random() * 100); // 영어점수 만들기
			int mat = (int) (Math.random() * 100); // 수학점수 만들기
			inData.SetData(i, name, kor, eng, mat); // 클래스 내 값 입력
		}

		int cnt = 0; // 1명 출력될 때 마다 세는 변수
		int cnt2 = 0; // 1명 출력될 때 마다 세는 변수
		int page = 1; // 페이지 세는 변수
		int i = 0;
		int pageKor = 0; // 페이지마다 누적 국어점수 누적 합
		int pageEng = 0; // 페이지마다 누적 영어점수 누적 합
		int pageMat = 0; // 페이지마다 누적 수학점수 누적 합
		int pageSum = 0; // 페이지마다 누적 합계점수 누적 합
		int pageAvg = 0; // 페이지마다 누적 평균점수 누적 합
		
		while (cnt <  (iPerson / pageOfPerson) + 1) { // 200명 셀 때 까지 반복
			cnt++; // 1명 출력되었으니 +1
			int korSum = 0; // 한 페이지에서만 국어점수 누적 합
			int engSum = 0; // 한 페이지에서만 영어점수 누적 합
			int matSum = 0; // 한 페이지에서만 수학점수 누적 합
			int sumSum = 0; // 한 페이지에서만 합계점수 누적 합
			double avgSum = 0; // 한 페이지에서만 평균점수 누적 합

			System.out.printf("                성적 집계표\n"); // 출력
			System.out.printf("PAGE: %d                    출력일자: %s\n", cnt+1, dateFormatter1.format(cal.getTime())); // 페이지, 출력일자 출력
			System.out.printf("=======================================================================\n"); // 출력
			System.out.printf("번호   이름     국어   영어   수학   총점     평균\n"); // 출력
			System.out.printf("=======================================================================\n"); // 출력
			
			// 입력된 값이 잘 들어갔는지 확인
			for (i = cnt2; i < pageOfPerson+cnt2; i++) { // 지정한 인원 수 만큼 반복

				System.out.printf("%03d%8s%7d%7d%7d%7d%9.0f\n",
						i + 1, inData.name[i], inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
				// 번호, 이름, 국어점수, 영어점수, 수학점수, 합계, 평균 출력
				
				cnt2++;
				korSum += inData.kor[i]; // 한 페이지에서만 누적하는 국어점수에 누적
				engSum += inData.eng[i]; // 한 페이지에서만 누적하는 영어점수에 누적
				matSum += inData.mat[i]; // 한 페이지에서만 누적하는 수학점수에 누적
				sumSum += inData.mat[i]; // 한 페이지에서만 누적하는 합계점수에 누적
				avgSum += inData.avg[i]; // 한 페이지에서만 누적하는 평균점수에 누적

				if (cnt % pageOfPerson == 0) { // 만약 횟수가 페이지당 인원수 나눈 나머지가 0이라면
					page++; // 페이지 +1 => 다음 페이지
					pageKor += korSum; // 페이지마다 누적 합에 한 페이지만 누적했던 국어점수 누적
					pageEng += engSum; // 페이지마다 누적 합에 한 페이지만 누적했던 영어점수 누적
					pageMat += matSum; // 페이지마다 누적 합에 한 페이지만 누적했던 수학점수 누적
					pageSum += sumSum; // 페이지마다 누적 합에 한 페이지만 누적했던 힙계점수 누적
					pageAvg += avgSum; // 페이지마다 누적 합에 한 페이지만 누적했던 평균점수 누적
					break; // while문 탈출
				}
				
			}

			System.out.printf("=======================================================================\n"); // 출력
			System.out.printf("현재페이지\n"); // 출력
			System.out.printf("합계%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum); // 한 페이지에서만 누적한 점수 출력
			System.out.printf("평균%16d%7d%7d%7d%9.0f\n", 
					korSum / iPerson, engSum / iPerson, matSum / iPerson, sumSum / iPerson, avgSum / iPerson); // 한 페이지에서만 누적한 점수의 평균 출력
			System.out.printf("=======================================================================\n");
			System.out.printf("누적페이지\n");
			System.out.printf("합계%16d%7d%7d%7d%9d\n", pageKor, pageEng, pageMat, pageSum, pageAvg); // 페이지마다 누적한 점수 출력
			System.out.printf("평균%16d%7d%7d%7d%9d\n\n\n",
					pageKor / cnt, pageEng / cnt, pageMat / cnt, pageSum / cnt, pageAvg / cnt);// 페이지 마다 누적한 점수의 평균 출력

		}
	}

}
*/