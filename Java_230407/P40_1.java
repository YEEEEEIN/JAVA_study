package Java_230407;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P40_1 {

	public static void main(String[] args) {
		 int iPerson = 200;// 이값을 주는 만큼 저장소 생성
	      int personNumber = 70; // 한페이지에 출력되는 인원수
	      InputData inData = new InputData(iPerson); // 생성자의 숫자를 준만큼 배열을 만든다

	      // 입력데이터 만들기
	      for (int i = 0; i < iPerson; i++) {
	         String name = String.format("홍길%02d", i + 1);
	         int kor = (int) (Math.random() * 100);
	         int eng = (int) (Math.random() * 100);
	         int mat = (int) (Math.random() * 100);
	         inData.SetData(i, name, kor, eng, mat);
	      }

	      int count = 0;
	      int page = 1;
	      int i = 0;
	      int pageKor = 0;
	      int pageEng = 0;
	      int pageMat = 0;
	      int pageSum = 0;
	      int pageAvg = 0;
	      

	      while (count < 200) {
	         int korSum = 0;
	         int EngSum = 0;
	         int matSum = 0;
	         int totalSum = 0;
	         int avgSum = 0;
	         System.out.println("                              성적집계표");
	         LocalDateTime time = LocalDateTime.now();
	         String k27_time = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// 날짜 출력 형식 포맷팅
	         System.out.println("PAGE: " + page + "                                             출력일자 : " + k27_time);
	         System.out.println("================================================================================");
	         System.out.println("번호        이름          국어        영어        수학        총점         평균");
	         System.out.println("================================================================================");

	         for (i = count; i < iPerson; i++) {
	            System.out.printf("번호:%03d    이름:%-7s국어:%-7d영어:%-7d수학:%-7d총점:%-8d평균:%-7d\n", i + 1, inData.name[i],
	                  inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
	            count++;

	            korSum += inData.kor[i];
	            EngSum += inData.eng[i];
	            matSum += inData.mat[i];
	            totalSum += inData.sum[i];
	            avgSum += inData.avg[i];

	            if (count % personNumber == 0) {
	               page++;
	               pageKor += korSum;
	               pageEng += EngSum;
	               pageMat += matSum;
	               pageSum += totalSum;
	               pageAvg += avgSum;
	               break;
	            }
	         }

	         System.out.println("================================================================================");
	         System.out.println("현재페이지");
	         System.out.printf("합계 %23d%11d%11d%11d%11d\n", korSum, EngSum, matSum, totalSum, avgSum);
	         System.out.printf("평균 %23d%11d%11d%11d%11d\n", korSum / personNumber, EngSum / personNumber,
	               matSum / personNumber, totalSum / personNumber, avgSum / personNumber);
	         System.out.println("================================================================================");
	         System.out.println("누적페이지");
	         System.out.printf("합계 %23d%11d%11d%11d%11d\n", pageKor, pageEng, pageMat, pageSum, pageAvg);
	         System.out.printf("평균 %23d%11d%11d%11d%11d\n", pageKor / count, pageEng / count, pageMat / count,
	               pageSum / count, pageAvg / count);
	         System.out.println();
	         System.out.println();
	      }


	}

}
