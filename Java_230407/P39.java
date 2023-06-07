package Java_230407;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P39 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar 클래스를 통해 인스턴스 생성
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 현재시간 출력 형식 지정


		int iPerson = 30; // 이 값을 주는 만큼 저장소 생성

		InputData inData = new InputData(iPerson); // 생성자의 숫자를 준 만큼 배열을 만든다.

		System.out.printf("                성적 집계표\n");
		System.out.printf("                           출력일자: %s\n", dateFormatter1.format(cal.getTime()));
		System.out.printf("=======================================================================\n");
		System.out.printf("번호   이름     국어   영어   수학   총점     평균\n");
		System.out.printf("=======================================================================\n");
		
		for (int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1); // 이름 만들기
			int kor = (int) (Math.random() * 100); // 국어점수 만들기
			int eng = (int) (Math.random() * 100); // 영어점수 만들기
			int mat = (int) (Math.random() * 100); // 수학점수 만들기
			inData.SetData(i, name, kor, eng, mat); // 클래스 내 값 입력

		}
		int korSum = 0;
		int engSum = 0;
		int matSum = 0;
		int sumSum = 0;
		double avgSum = 0;
		// 입력된 값이 잘 들어갔는지 확인
		for (int i = 0; i < iPerson; i++) {

			System.out.printf("%03d%8s%7d%7d%7d%7d%9.0f\n", i + 1, inData.name[i], inData.kor[i], inData.eng[i],
					inData.mat[i], inData.sum[i], inData.avg[i]);

			korSum += inData.kor[i];
			engSum += inData.eng[i];
			matSum += inData.mat[i];
			sumSum += inData.mat[i];
			avgSum += inData.avg[i];
		}
		System.out.printf("=======================================================================\n");
		System.out.printf("합계%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum);
		System.out.printf("평균%16d%7d%7d%7d%9.0f\n", korSum / iPerson, engSum / iPerson, matSum / iPerson,
				sumSum / iPerson, avgSum / iPerson);

	}

}
