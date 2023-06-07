package Java_230407;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P39 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Calendar Ŭ������ ���� �ν��Ͻ� ����
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // ����ð� ��� ���� ����


		int iPerson = 30; // �� ���� �ִ� ��ŭ ����� ����

		InputData inData = new InputData(iPerson); // �������� ���ڸ� �� ��ŭ �迭�� �����.

		System.out.printf("                ���� ����ǥ\n");
		System.out.printf("                           �������: %s\n", dateFormatter1.format(cal.getTime()));
		System.out.printf("=======================================================================\n");
		System.out.printf("��ȣ   �̸�     ����   ����   ����   ����     ���\n");
		System.out.printf("=======================================================================\n");
		
		for (int i = 0; i < iPerson; i++) {
			String name = String.format("ȫ��%02d", i + 1); // �̸� �����
			int kor = (int) (Math.random() * 100); // �������� �����
			int eng = (int) (Math.random() * 100); // �������� �����
			int mat = (int) (Math.random() * 100); // �������� �����
			inData.SetData(i, name, kor, eng, mat); // Ŭ���� �� �� �Է�

		}
		int korSum = 0;
		int engSum = 0;
		int matSum = 0;
		int sumSum = 0;
		double avgSum = 0;
		// �Էµ� ���� �� ������ Ȯ��
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
		System.out.printf("�հ�%16d%7d%7d%7d%9.0f\n", korSum, engSum, matSum, sumSum, avgSum);
		System.out.printf("���%16d%7d%7d%7d%9.0f\n", korSum / iPerson, engSum / iPerson, matSum / iPerson,
				sumSum / iPerson, avgSum / iPerson);

	}

}
