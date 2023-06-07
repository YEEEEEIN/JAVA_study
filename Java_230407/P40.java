package Java_230407;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P40 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // ����ð� ��� ���� ����

		int iPerson = 200; // �� ���� �ִ� ��ŭ ����� ����
		int pageOfPerson = 30; // �� �������� ��µǴ� �ο���

		InputData inData = new InputData(iPerson); // �������� ���ڸ� �� ��ŭ �迭�� �����.

		for (int i = 0; i < iPerson; i++) {
			String name = String.format("ȫ��%02d", i + 1); // �̸� �����
			int kor = (int) (Math.random() * 100); // �������� �����
			int eng = (int) (Math.random() * 100); // �������� �����
			int mat = (int) (Math.random() * 100); // �������� �����
			inData.SetData(i, name, kor, eng, mat); // Ŭ���� �� �� �Է�
		}

		int cnt = 0; // 1�� ��µ� �� ���� ���� ����
		int page = 1; // ������ ���� ����
		int i = 0;
		int pageKor = 0; // ���������� ���� �������� ���� ��
		int pageEng = 0; // ���������� ���� �������� ���� ��
		int pageMat = 0; // ���������� ���� �������� ���� ��
		int pageSum = 0; // ���������� ���� �հ����� ���� ��
		int pageAvg = 0; // ���������� ���� ������� ���� ��
		
		while (cnt <  200) { // 200�� �� �� ���� �ݺ�
			int korSum = 0; // �� ������������ �������� ���� ��
			int engSum = 0; // �� ������������ �������� ���� ��
			int matSum = 0; // �� ������������ �������� ���� ��
			int sumSum = 0; // �� ������������ �հ����� ���� ��
			double avgSum = 0; // �� ������������ ������� ���� ��

			System.out.printf("                ���� ����ǥ\n"); // ���
			System.out.printf("PAGE: %d                    �������: %s\n", page, dateFormatter1.format(cal.getTime())); // ������, ������� ���
			System.out.printf("=======================================================================\n"); // ���
			System.out.printf("��ȣ   �̸�     ����   ����   ����   ����     ���\n"); // ���
			System.out.printf("=======================================================================\n"); // ���
			
			// �Էµ� ���� �� ������ Ȯ��
			for (i = cnt; i < iPerson; i++) { // ������ �ο� �� ��ŭ �ݺ�

				System.out.printf("%03d%8s%7d%7d%7d%7d%9.0f\n",
						i + 1, inData.name[i], inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
				// ��ȣ, �̸�, ��������, ��������, ��������, �հ�, ��� ���
				
				cnt++;
				
				korSum += inData.kor[i]; // �� ������������ �����ϴ� ���������� ����
				engSum += inData.eng[i]; // �� ������������ �����ϴ� ���������� ����
				matSum += inData.mat[i]; // �� ������������ �����ϴ� ���������� ����
				sumSum += inData.mat[i]; // �� ������������ �����ϴ� �հ������� ����
				avgSum += inData.avg[i]; // �� ������������ �����ϴ� ��������� ����

				if (cnt % pageOfPerson == 0) { // ���� Ƚ���� �������� �ο��� ���� �������� 0�̶��
					page++; // ������ +1 => ���� ������
					pageKor += korSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageEng += engSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageMat += matSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageSum += sumSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageAvg += avgSum; // ���������� ���� �տ� �� �������� �����ߴ� ������� ����
					break; // for�� Ż��
				}
				
			}

			System.out.printf("=======================================================================\n"); // ���
			System.out.printf("����������\n"); // ���
			System.out.printf("�հ�%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum); // �� ������������ ������ ���� ���
			System.out.printf("���%16d%7d%7d%7d%9.0f\n", 
					korSum / iPerson, engSum / iPerson, matSum / iPerson, sumSum / iPerson, avgSum / iPerson); // �� ������������ ������ ������ ��� ���
			System.out.printf("=======================================================================\n");
			System.out.printf("����������\n");
			System.out.printf("�հ�%16d%7d%7d%7d%9d\n", pageKor, pageEng, pageMat, pageSum, pageAvg); // ���������� ������ ���� ���
			System.out.printf("���%16d%7d%7d%7d%9d\n\n\n",
					pageKor / cnt, pageEng / cnt, pageMat / cnt, pageSum / cnt, pageAvg / cnt);// ������ ���� ������ ������ ��� ���

		}
	}

}






/*
package PPT06;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P40 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // ����ð� ��� ���� ����

		int iPerson = 200; // �� ���� �ִ� ��ŭ ����� ����
		int pageOfPerson = 30; // �� �������� ��µǴ� �ο���

		InputData inData = new InputData(iPerson); // �������� ���ڸ� �� ��ŭ �迭�� �����.

		for (int i = 0; i < iPerson; i++) {
			String name = String.format("ȫ��%02d", i + 1); // �̸� �����
			int kor = (int) (Math.random() * 100); // �������� �����
			int eng = (int) (Math.random() * 100); // �������� �����
			int mat = (int) (Math.random() * 100); // �������� �����
			inData.SetData(i, name, kor, eng, mat); // Ŭ���� �� �� �Է�
		}

		int cnt = 0; // 1�� ��µ� �� ���� ���� ����
		int cnt2 = 0; // 1�� ��µ� �� ���� ���� ����
		int page = 1; // ������ ���� ����
		int i = 0;
		int pageKor = 0; // ���������� ���� �������� ���� ��
		int pageEng = 0; // ���������� ���� �������� ���� ��
		int pageMat = 0; // ���������� ���� �������� ���� ��
		int pageSum = 0; // ���������� ���� �հ����� ���� ��
		int pageAvg = 0; // ���������� ���� ������� ���� ��
		
		while (cnt <  (iPerson / pageOfPerson) + 1) { // 200�� �� �� ���� �ݺ�
			cnt++; // 1�� ��µǾ����� +1
			int korSum = 0; // �� ������������ �������� ���� ��
			int engSum = 0; // �� ������������ �������� ���� ��
			int matSum = 0; // �� ������������ �������� ���� ��
			int sumSum = 0; // �� ������������ �հ����� ���� ��
			double avgSum = 0; // �� ������������ ������� ���� ��

			System.out.printf("                ���� ����ǥ\n"); // ���
			System.out.printf("PAGE: %d                    �������: %s\n", cnt+1, dateFormatter1.format(cal.getTime())); // ������, ������� ���
			System.out.printf("=======================================================================\n"); // ���
			System.out.printf("��ȣ   �̸�     ����   ����   ����   ����     ���\n"); // ���
			System.out.printf("=======================================================================\n"); // ���
			
			// �Էµ� ���� �� ������ Ȯ��
			for (i = cnt2; i < pageOfPerson+cnt2; i++) { // ������ �ο� �� ��ŭ �ݺ�

				System.out.printf("%03d%8s%7d%7d%7d%7d%9.0f\n",
						i + 1, inData.name[i], inData.kor[i], inData.eng[i], inData.mat[i], inData.sum[i], inData.avg[i]);
				// ��ȣ, �̸�, ��������, ��������, ��������, �հ�, ��� ���
				
				cnt2++;
				korSum += inData.kor[i]; // �� ������������ �����ϴ� ���������� ����
				engSum += inData.eng[i]; // �� ������������ �����ϴ� ���������� ����
				matSum += inData.mat[i]; // �� ������������ �����ϴ� ���������� ����
				sumSum += inData.mat[i]; // �� ������������ �����ϴ� �հ������� ����
				avgSum += inData.avg[i]; // �� ������������ �����ϴ� ��������� ����

				if (cnt % pageOfPerson == 0) { // ���� Ƚ���� �������� �ο��� ���� �������� 0�̶��
					page++; // ������ +1 => ���� ������
					pageKor += korSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageEng += engSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageMat += matSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageSum += sumSum; // ���������� ���� �տ� �� �������� �����ߴ� �������� ����
					pageAvg += avgSum; // ���������� ���� �տ� �� �������� �����ߴ� ������� ����
					break; // while�� Ż��
				}
				
			}

			System.out.printf("=======================================================================\n"); // ���
			System.out.printf("����������\n"); // ���
			System.out.printf("�հ�%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum); // �� ������������ ������ ���� ���
			System.out.printf("���%16d%7d%7d%7d%9.0f\n", 
					korSum / iPerson, engSum / iPerson, matSum / iPerson, sumSum / iPerson, avgSum / iPerson); // �� ������������ ������ ������ ��� ���
			System.out.printf("=======================================================================\n");
			System.out.printf("����������\n");
			System.out.printf("�հ�%16d%7d%7d%7d%9d\n", pageKor, pageEng, pageMat, pageSum, pageAvg); // ���������� ������ ���� ���
			System.out.printf("���%16d%7d%7d%7d%9d\n\n\n",
					pageKor / cnt, pageEng / cnt, pageMat / cnt, pageSum / cnt, pageAvg / cnt);// ������ ���� ������ ������ ��� ���

		}
	}

}
*/