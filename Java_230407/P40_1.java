package Java_230407;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P40_1 {

	public static void main(String[] args) {
		 int iPerson = 200;// �̰��� �ִ� ��ŭ ����� ����
	      int personNumber = 70; // ���������� ��µǴ� �ο���
	      InputData inData = new InputData(iPerson); // �������� ���ڸ� �ظ�ŭ �迭�� �����

	      // �Էµ����� �����
	      for (int i = 0; i < iPerson; i++) {
	         String name = String.format("ȫ��%02d", i + 1);
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
	         System.out.println("                              ��������ǥ");
	         LocalDateTime time = LocalDateTime.now();
	         String k27_time = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// ��¥ ��� ���� ������
	         System.out.println("PAGE: " + page + "                                             ������� : " + k27_time);
	         System.out.println("================================================================================");
	         System.out.println("��ȣ        �̸�          ����        ����        ����        ����         ���");
	         System.out.println("================================================================================");

	         for (i = count; i < iPerson; i++) {
	            System.out.printf("��ȣ:%03d    �̸�:%-7s����:%-7d����:%-7d����:%-7d����:%-8d���:%-7d\n", i + 1, inData.name[i],
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
	         System.out.println("����������");
	         System.out.printf("�հ� %23d%11d%11d%11d%11d\n", korSum, EngSum, matSum, totalSum, avgSum);
	         System.out.printf("��� %23d%11d%11d%11d%11d\n", korSum / personNumber, EngSum / personNumber,
	               matSum / personNumber, totalSum / personNumber, avgSum / personNumber);
	         System.out.println("================================================================================");
	         System.out.println("����������");
	         System.out.printf("�հ� %23d%11d%11d%11d%11d\n", pageKor, pageEng, pageMat, pageSum, pageAvg);
	         System.out.printf("��� %23d%11d%11d%11d%11d\n", pageKor / count, pageEng / count, pageMat / count,
	               pageSum / count, pageAvg / count);
	         System.out.println();
	         System.out.println();
	      }


	}

}
